package com.prototype.payments.service.implement;


import com.prototype.payments.service.RefundService;
import com.prototype.payments.service.entities.MerchantEntity;
import com.prototype.payments.service.entities.RefundEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.thirdyparty.payu.api.PayUClient;
import com.prototype.payments.thirdyparty.payu.dto.PaymentResponse;
import com.prototype.payments.thirdyparty.payu.dto.Refund;
import com.prototype.payments.thirdyparty.payu.dto.mappers.PaymentDTOEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RefundServiceImplement implements RefundService {

    @Autowired
    PaymentDTOEntityMapper paymentDTOEntityMapper;

    @Autowired
    PayUClient payUClient;


    @Override
    public ResponseEntity createRefund(RefundEntity refundEntity) {
        refundEntity.setMerchantEntity(new MerchantEntity());
        Refund refund = paymentDTOEntityMapper.refundToRefundEntity(refundEntity);
        PaymentResponse paymentResponse = payUClient.refundClient(refund);
        return paymentDTOEntityMapper.paymentEntityToPayment(paymentResponse);
    }
}
