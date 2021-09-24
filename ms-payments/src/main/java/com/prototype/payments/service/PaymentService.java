package com.prototype.payments.service;


import com.prototype.payments.exception.PaymentServerErrorException;
import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.service.entities.RefundEntity;

/**
 * Interface to define the method about the payment
 * @version 0.0.1
 * @since 22/09/21
 */
public interface PaymentService {

    /**
     * Process that performs the payment creation
     *
     * @param paymentRequestDTO Object containing payment data
     * @return Object containing the payment response data
     */
    ResponseEntity createPayment(PaymentEntity paymentRequestDTO) throws PaymentServerErrorException;

}
