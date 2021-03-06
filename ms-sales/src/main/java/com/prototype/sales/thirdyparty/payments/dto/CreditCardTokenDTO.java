package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardTokenDTO extends CreditCardDTO {

    private String identificationNumber;
    private String paymentMethod;
}
