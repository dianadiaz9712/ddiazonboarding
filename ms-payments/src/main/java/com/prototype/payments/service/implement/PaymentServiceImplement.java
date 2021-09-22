package com.prototype.payments.service.implement;

import java.util.Optional;

import com.prototype.payments.constant.PaymentMessages;
import com.prototype.payments.exception.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.payments.constant.PaymentConstant;
import com.prototype.payments.model.BankModel;
import com.prototype.payments.model.CardModel;
import com.prototype.payments.model.CurrencyModel;
import com.prototype.payments.model.PaymentMethodModel;
import com.prototype.payments.model.PaymentModel;
import com.prototype.payments.repository.BankRepository;
import com.prototype.payments.repository.CardRepository;
import com.prototype.payments.repository.CurrencyRepository;
import com.prototype.payments.repository.PaymentMethodRepository;
import com.prototype.payments.repository.PaymentRepository;
import com.prototype.payments.repository.mappers.PaymentRepositoryMapper;
import com.prototype.payments.service.PaymentService;
import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import com.prototype.payments.thirdyparty.payu.api.PayUClient;
import com.prototype.payments.thirdyparty.payu.dto.Payment;
import com.prototype.payments.thirdyparty.payu.dto.PaymentResponse;
import com.prototype.payments.thirdyparty.payu.dto.mappers.PaymentDTOEntityMapper;
import com.prototype.payments.util.Encryption;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceImplement implements PaymentService {

	@Autowired
     PaymentDTOEntityMapper paymentDTOEntityMapper;

	@Autowired
     PaymentRepositoryMapper paymentRepositoryMapper;

    @Autowired
     PayUClient payUClient;

    @Autowired
     PaymentRepository paymentRepository;

    @Autowired
     CardRepository cardRepository;

    @Autowired
     CurrencyRepository currencyRepository;

    @Autowired
     PaymentMethodRepository paymentMethodRepository;

    @Autowired
     BankRepository bankRepository;


    @Override
    public ResponseEntity createPayment(PaymentEntity paymentEntity) {

        Payment payment = paymentDTOEntityMapper.paymentToPaymentEntity(paymentEntity);
        String tokenCard = processToken(paymentEntity.getTransactionEntity().cardToken, payment);
        PaymentResponse paymentResponse = payUClient.authorizationCaptureClient(payment);

        CurrencyModel currencyModel = findCurrency(payment.getTransaction().getOrder().getAdditionalValues().getTxValue().getCurrency());
        PaymentMethodModel paymentMethodModel = findPaymentMethod(payment.getTransaction().getPaymentMethod());

        if(paymentResponse.getCode().equals("SUCCESS")) {
            PaymentModel paymentModel = new PaymentModel();
            paymentModel.setPaymentMethodModel(paymentMethodModel);
            paymentModel.setCurrencyModel(currencyModel);
            CardModel cardModel = saveCardModel(paymentEntity, tokenCard);
            paymentModel.setCardModel(cardModel);
            paymentModel.setState(PaymentConstant.ACTIVO);
            paymentRepository.save(paymentModel);
        }

        return paymentDTOEntityMapper.paymentEntityToPayment(paymentResponse);
    }

    /**
     *  Method for creating Card for client
     * @param paymentEntity
     * @param tokenCard
     * @return
     */
    private CardModel saveCardModel(PaymentEntity paymentEntity, String tokenCard) {

        BankModel bankModel = findBank(paymentEntity.getTransactionEntity().getCreditCardEntity().getBank());
        String codeCard = extractCodeCard(paymentEntity.getTransactionEntity().getCreditCardEntity().getNumber());
        CardModel cardModel = paymentRepositoryMapper.cardEntityToEntityModelToken(paymentEntity.getTransactionEntity());
        cardModel.setBank(bankModel);
        cardModel.setTokenCard(tokenCard);
        cardModel.setCodeCard(codeCard);
        cardRepository.save(cardModel);
        return cardModel;
    }


    /**
     *  Method for get the encrypted code card
     * @param numberCard
     * @return
     */
    private String extractCodeCard(String numberCard) {
        int length = numberCard.length();
        return Encryption.encrypt(numberCard.substring(length -4 , length));
    }


    /**
     *  Method for consulting Payment Method for name
     * @param paymentMethod
     * @return
     */
    private PaymentMethodModel findPaymentMethod(String paymentMethod) {
        
        Optional<PaymentMethodModel> optionalPaymentMethod = paymentMethodRepository.findByNameContaining(paymentMethod);

        if(optionalPaymentMethod.isPresent()){
            return  optionalPaymentMethod.get();
        }else{
            throw new PaymentNotFoundException(PaymentMessages.DESCP0003);
        }
    }

    /**
     *  Method for consulting Bank for name
     * @param bank
     * @return
     */
    private BankModel findBank(String bank) {
       Optional<BankModel> optionalBankModel =  bankRepository.findByNameBankContaining(bank);
        if(optionalBankModel.isPresent()){
            return  optionalBankModel.get();
        }else{
            throw new PaymentNotFoundException(PaymentMessages.DESCP0001);
        }

    }

    /**
     *  Method for consulting Currency for code
     * @param currency
     * @return
     */
    private CurrencyModel findCurrency(String currency) {
       Optional<CurrencyModel> optionalCurrency =  currencyRepository.findByCodeCurrencyContaining(currency);
       if(optionalCurrency.isPresent()){
           return  optionalCurrency.get();
       }else{
           throw new PaymentNotFoundException(PaymentMessages.DESCP0002);
       }

    }

    private String processToken(Boolean cardToken,  Payment payment) {
        String tokenCard = "";
        if (cardToken) {
            //INTEGRACION CON MICRO TOKEN
            payment.getTransaction().setCreditCardTokenId(tokenCard);
        }
        return tokenCard;
    }



}
