package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditCardTokenEntity extends CreditCardEntity{

    private String payerId;
    private String identificationNumber;
    private String paymentMethod;

}
