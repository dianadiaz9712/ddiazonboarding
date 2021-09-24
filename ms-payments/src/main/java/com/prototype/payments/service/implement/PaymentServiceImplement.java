package com.prototype.payments.service.implement;

import com.prototype.payments.exception.PaymentServerErrorException;
import com.prototype.payments.repository.provider.PaymentProvider;
import com.prototype.payments.thirdyparty.payu.provider.PayuProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.payments.service.PaymentService;
import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.util.Encryption;

import lombok.extern.slf4j.Slf4j;

/**
 *  @version 0.0.1
 *  @since 22/09/21
 */
@Service
@Slf4j
public class PaymentServiceImplement implements PaymentService {

    @Autowired
    PayuProvider payuProvider;

    @Autowired
    PaymentProvider paymentProvider;


    @Override
    public ResponseEntity createPayment(PaymentEntity paymentEntity) throws PaymentServerErrorException {
        String codeCard = paymentEntity.getTransactionEntity().isCardToken() ? extractCodeCard(paymentEntity.getTransactionEntity().getCreditCardTokenEntity().getNumber()) : null;
        String tokenCard = generateToken(paymentEntity.getTransactionEntity().isCardToken());
        ResponseEntity responseEntity = payuProvider.authorizationCaptureClient(paymentEntity, tokenCard);
       return paymentProvider.createPayment(paymentEntity, responseEntity, tokenCard,codeCard );
    }

    /**
     *  Method for get the encrypted code card
     * @param numberCard
     * @return
     */
    private String extractCodeCard(String numberCard) throws PaymentServerErrorException {
        int length = numberCard.length();
        return Encryption.encrypt(numberCard.substring(length -4 , length));
    }


    private String generateToken(Boolean cardToken) {
        String tokenCard = null;
        if (cardToken) {
            //INTEGRACION CON MICRO TOKEN

        }
        return tokenCard;
    }



}
