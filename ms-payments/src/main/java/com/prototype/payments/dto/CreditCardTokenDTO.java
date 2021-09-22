package com.prototype.payments.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardTokenDTO extends CreditCardDTO {

    @ApiModelProperty(value = "El número de identificacion de la tarjeta", name = "identificationNumber", dataType = "String", required = false, example = "1233568945")
    private String identificationNumber;
    @ApiModelProperty(value = "Metodo de pago de la tarjeta", name = "identificationNumber", dataType = "String", required = false, example = "VISA")
    private String paymentMethod;
}
