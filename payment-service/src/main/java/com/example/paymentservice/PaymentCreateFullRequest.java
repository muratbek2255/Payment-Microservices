package com.example.paymentservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentCreateFullRequest {

    private Integer price;

    private String accountCheck;
}
