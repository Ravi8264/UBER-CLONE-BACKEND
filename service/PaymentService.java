package com.example.Uber.service;

import com.example.Uber.entities.Payment;
import com.example.Uber.entities.Ride;
import com.example.Uber.entities.enus.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
