package com.example.paymentservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public String addPayment(String favour) {

        Payment payment = new Payment();

        payment.setStatus(PaymentStatus.STATUS_PROCESS);
        payment.setCreated_at(Timestamp.from(Instant.now()));
        payment.setFinished(Boolean.FALSE);
        payment.setFavour(favour);

        paymentRepository.save(payment);

        return "Add Payment";
    }

    @Override
    public String checkPayment(PaymentCheckRequest paymentCheckRequest, int id) {
        if(paymentCheckRequest.getSumOfFavour() > 500 && paymentCheckRequest.getSumOfFavour() < 25000 &&
                paymentCheckRequest.getAccountCheck() != null) {

            Payment payment = paymentRepository.getById(id);

            payment.setIsChecked(Boolean.TRUE);;

            paymentRepository.save(payment);

            return "Order is checked!";

        } else  {

            return "Error, you have problem with sumOfFavour or AccountCheck!";

        }
    }

    @Override
    public String addStatus(PaymentCreateFullRequest paymentCreateFullRequest, int id) {
        Payment payment = paymentRepository.getById(id);

        if(payment.getIsChecked().equals(Boolean.TRUE)) {

            payment.setStatus(PaymentStatus.STATUS_CREATED);
            payment.setCreated_at(Timestamp.from(Instant.now()));
            payment.setFinished(Boolean.FALSE);
            payment.setSumOfFavour(paymentCreateFullRequest.getPrice());
            payment.setAccountCheck(paymentCreateFullRequest.getAccountCheck());

            paymentRepository.save(payment);

            return "Payment Created";
        }else {
            return "You have some with problem with AccountCheck or SumOfFavour";
        }
    }

    @Override
    public String setStatus(int id) {

        Payment payment = paymentRepository.getById(id);

        payment.setFinished(Boolean.TRUE);

        if(payment.getFinished().equals(Boolean.TRUE)) {
            payment.setStatus(PaymentStatus.STATUS_SUCCESS);
        }

        payment.setUpdated_at(Timestamp.from(Instant.now()));

        paymentRepository.save(payment);

        return "Your status in payment: " + payment.getStatus();
    }

    @Override
    public String rollbackPayment(int id) {
        Payment payment = paymentRepository.getById(id);

        if(payment.getStatus().equals(PaymentStatus.STATUS_SUCCESS)) {

            long Milli = Math.abs(payment.getUpdated_at().getTime() - new Date().getTime());

            if(Milli < 1080000) {
                payment.setStatus(PaymentStatus.STATUS_ROLLBACK);
            } else {
                return "3 days gone";
            }
        } else if(payment.getStatus().equals(PaymentStatus.STATUS_CREATED)) {
            payment.setStatus(PaymentStatus.STATUS_ROLLBACK);
        } else {
            return "You dont have payment or your status fail";
        }

        payment.setUpdated_at(Timestamp.from(Instant.now()));

        paymentRepository.save(payment);

        return "Rollback payment";
    }

    @Override
    public String getByStatus(String status) {
        List<Payment> payment = paymentRepository.getByStatus(status);

        return "Payment with status: " + payment;
    }
}
