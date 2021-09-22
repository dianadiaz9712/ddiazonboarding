package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {

    private String number;
    private boolean processWithoutCvv2 ;
    private String expirationDate;
    private String name;
}
