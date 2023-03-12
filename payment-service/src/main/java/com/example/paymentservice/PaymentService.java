package com.example.paymentservice;


public interface PaymentService {
    public String addPayment(String favourId);

    public String checkPayment(PaymentCheckRequest paymentCheckRequest, int id);

    public String addStatus(PaymentCreateFullRequest paymentCreateFullRequest, int id);

    public String setStatus(int id);

    public String rollbackPayment(int id);

    public String getByStatus(String status);
}
