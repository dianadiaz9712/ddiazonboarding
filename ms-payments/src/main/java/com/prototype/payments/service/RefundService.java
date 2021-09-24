package com.prototype.payments.service;

import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.service.entities.ResponseEntity;

/**
 * Interface to define the method about the refund
 * @version 0.0.1
 * @since 22/09/21
 */
public interface RefundService {

    /**
     * Process that performs the refund creation
     *
     * @param refundEntity Object containing the refund data
     * @return Object containing the payment response data
     */
    ResponseEntity createRefund(RefundEntity refundEntity);
}
