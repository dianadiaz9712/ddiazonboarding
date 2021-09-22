package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardEntity {

    private String bank;
    private String number;
    public boolean processWithoutCvv2;
    private String expirationDate;
    private String name;
}
