package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionEntity {

    private OrderEntity orderEntity;

    private CreditCardEntity creditCardEntity;
    private boolean cardToken;
    private CreditCardTokenEntity creditCardTokenEntity;
    private PayerEntity payerEntity;
    private String type;
    private String paymentMethod;
    private String paymentCountry;
    private String deviceSessionId;
    private String ipAddress;
    private String cookie;
    private String userAgent;
    private ExtraParametersEntity extraParametersEntity;

    private ThreeDomainSecureEntity threeDomainSecureEntity;

    public String platform;
}
