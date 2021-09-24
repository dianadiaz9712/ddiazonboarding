package com.prototype.payments.repository.provider;

import com.prototype.payments.constant.PaymentConstant;
import com.prototype.payments.constant.PaymentMessages;
import com.prototype.payments.exception.PaymentNotFoundException;
import com.prototype.payments.exception.PaymentServerErrorException;
import com.prototype.payments.model.*;
import com.prototype.payments.repository.*;
import com.prototype.payments.repository.mappers.PaymentRepositoryMapper;
import com.prototype.payments.service.entities.PaymentEntity;
import com.prototype.payments.service.entities.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import java.util.Optional;


@Component
@Slf4j
public class PaymentProvider {

    @Autowired
    PaymentRepositoryMapper paymentRepositoryMapper;

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


    /**
     * Method for creating payment for client
     * @param paymentEntity
     * @param responseEntity
     * @param tokenCard
     * @param codeCard
     * @return
     */
    public ResponseEntity createPayment(PaymentEntity paymentEntity, ResponseEntity responseEntity, String tokenCard, String codeCard) throws PaymentServerErrorException {

        CurrencyModel currencyModel = findCurrency(paymentEntity.getTransactionEntity().getOrderEntity().getAdditionalValuesEntity().getTxValueEntity().getCurrency());
        PaymentMethodModel paymentMethodModel = findPaymentMethod(paymentEntity.getTransactionEntity().getPaymentMethod());

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setPaymentMethodModel(paymentMethodModel);
        paymentModel.setCurrencyModel(currencyModel);

        CardModel cardModel = paymentEntity.getTransactionEntity().isCardToken() ? saveCardModel(paymentEntity, tokenCard, codeCard): null;
        paymentModel.setCardModel(cardModel);
        paymentModel.setState(responseEntity.getTransactionResponseEntity().getState().equals(PaymentConstant.APPROVED) ? PaymentConstant.APROBADO : PaymentConstant.DECLINADO);

        paymentRepository.save(paymentModel);
        responseEntity.setIdPayment(paymentModel.getId());
        return responseEntity;
    }

    /**
     *  Method for creating Card for client
     * @param paymentEntity
     * @param tokenCard
     * @return
     */
    private CardModel saveCardModel(PaymentEntity paymentEntity, String tokenCard,  String codeCard) throws PaymentServerErrorException {
        try {
            BankModel bankModel = findBank(paymentEntity.getTransactionEntity().getCreditCardEntity().getBank());
            CardModel cardModel = paymentRepositoryMapper.cardEntityToEntityModelToken(paymentEntity.getTransactionEntity(), bankModel , tokenCard);
            cardModel.setCodeCard(codeCard);
            cardRepository.save(cardModel);
            return cardModel;
        }catch (PersistenceException persistenceException){
            log.error("Se presento un error en saveCardModel, {}", persistenceException.getMessage());
            throw new PaymentServerErrorException(PaymentMessages.DESCP0004);
        }
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
            log.error(PaymentMessages.DESCP0003, " para el medio de pago " + paymentMethod );
            throw new PaymentNotFoundException(PaymentMessages.DESCP0003);
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
            log.error(PaymentMessages.DESCP0002, " para el codigo de moneda " + currency);
            throw new PaymentNotFoundException(PaymentMessages.DESCP0002);
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
            log.error(PaymentMessages.DESCP0001, " para el banco " + bank);
            throw new PaymentNotFoundException(PaymentMessages.DESCP0001);
        }

    }
}
