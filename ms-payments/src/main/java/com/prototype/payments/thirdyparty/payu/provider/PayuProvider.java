package com.prototype.payments.thirdyparty.payu.provider;

import com.prototype.payments.service.entities.MerchantEntity;
import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.thirdyparty.payu.api.PayUClient;
import com.prototype.payments.thirdyparty.payu.dto.Payment;
import com.prototype.payments.thirdyparty.payu.dto.PaymentResponse;
import com.prototype.payments.thirdyparty.payu.dto.Refund;
import com.prototype.payments.thirdyparty.payu.dto.mappers.PaymentDTOEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayuProvider {

    @Autowired
    PayUClient payUClient;

    @Autowired
    PaymentDTOEntityMapper paymentDTOEntityMapper;

    public ResponseEntity authorizationCaptureClient(PaymentEntity paymentEntity, String tokenCard){
        Payment payment = paymentDTOEntityMapper.paymentToPaymentEntity(paymentEntity, tokenCard);
        return paymentDTOEntityMapper.paymentResponseEntityToResponse(payUClient.authorizationCaptureClient(payment));
    }


    public ResponseEntity refund(RefundEntity refundEntity){
        refundEntity.setMerchantEntity(new MerchantEntity());
        Refund refund = paymentDTOEntityMapper.refundToRefundEntity(refundEntity);
        return paymentDTOEntityMapper.paymentResponseEntityToResponse(payUClient.refundClient(refund));
    }


}
