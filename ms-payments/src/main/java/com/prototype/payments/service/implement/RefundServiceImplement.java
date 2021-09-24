package com.prototype.payments.service.implement;


import com.prototype.payments.service.RefundService;
import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.thirdyparty.payu.provider.PayuProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  @version 0.0.1
 *  @since 22/09/21
 */
@Service
@Slf4j
public class RefundServiceImplement implements RefundService {


    @Autowired
    PayuProvider payuProvider;


    @Override
    public ResponseEntity createRefund(RefundEntity refundEntity) {
        return  payuProvider.refund(refundEntity);
    }
}
