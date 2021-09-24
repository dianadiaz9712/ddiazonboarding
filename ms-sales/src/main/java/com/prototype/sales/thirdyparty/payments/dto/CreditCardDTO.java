package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardDTO {

    public String number;

    public String expirationDate;

    public String name;

    public boolean processWithoutCvv2;

    private String bank;
}
