package com.prototype.payments.service;


import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.service.entities.RefundEntity;

public interface PaymentService {

    ResponseEntity createPayment(PaymentEntity paymentRequestDTO);

}
