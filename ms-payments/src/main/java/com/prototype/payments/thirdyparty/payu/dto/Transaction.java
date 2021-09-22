package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {

    private Order order;
    private CreditCard creditCard;
    private String creditCardTokenId;
    private Payer payer;
    private String type;
    private String paymentMethod;
    private String paymentCountry;
    private String deviceSessionId;
    private String ipAddress;
    private String cookie;
    private String userAgent;

    private ThreeDomainSecure threeDomainSecure;//
}
