package com.example.paymentservice;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    PaymentStatus status;

    @Column(name = "created_at")
    Timestamp created_at;

    @Column(name = "updated_at")
    Timestamp updated_at;

    @Column(name = "sum_of_favour")
    Integer sumOfFavour;

    @Column(name = "favour")
    String favour;

    @Column(name = "account_check")
    String accountCheck;

    @Column(name = "is_checked")
    Boolean isChecked;

    @Column(name = "finished")
    Boolean finished;
}

