package com.prototype.payments.service;

import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.service.entities.ResponseEntity;

public interface RefundService {

    ResponseEntity createRefund(RefundEntity refundEntity);
}
