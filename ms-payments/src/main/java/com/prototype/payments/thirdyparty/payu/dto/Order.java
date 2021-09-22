package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private int accountId;
    private String referenceCode;
    private String description;
    private String language;


    private String notifyUrl;
    private Buyer buyer;

    private AdditionalValues additionalValues;
    private ShippingAddress shippingAddress;
}
