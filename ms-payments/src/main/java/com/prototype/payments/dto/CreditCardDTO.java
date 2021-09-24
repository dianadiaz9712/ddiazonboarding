package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class CreditCardDTO {

    @ApiModelProperty(value = "El número de la tarjeta de crédito.", name = "number", dataType = "String", required = true, example = "5414791252800746")
    @NotNull(message = "El campo number no puede ser nulo")
    @NotEmpty(message = "El campo number no puede ser vacio")
    private String number;

    @ApiModelProperty(value = "La fecha de expiración de la tarjeta de crédito", name = "expirationDate", dataType = "String", required = true, example = "2031/10")
    @NotNull(message = "El campo expirationDate no puede ser nulo")
    @NotEmpty(message = "El campo expirationDate no puede ser vacio")
    private String expirationDate;

    @ApiModelProperty(value = "El nombre que aparece en la tarjeta de crédito.", name = "name", dataType = "String", required = true, example = "DIANA P DIAZ M")
    @NotNull(message = "El campo name no puede ser nulo")
    @NotEmpty(message = "El campo name no puede ser vacio")
    private String name;

    @ApiModelProperty(value = "Permite procesar transacciones de tarjeta de crédito sin incluir el código de seguridad .", name = "processWithoutCvv2", dataType = "boolean", required = true, example = "true")
    @NotNull(message = "El campo processWithoutCvv2 no puede ser nulo")
    @NotEmpty(message = "El campo processWithoutCvv2 no puede ser vacio")
    private boolean processWithoutCvv2;

    @ApiModelProperty(value = "Nombre del banco al cual pertenece la tarjeta.", name = "bank", dataType = "String", required = true, example = "BANCOLOMBIA")
    @NotNull(message = "El campo bank no puede ser nulo")
    @NotEmpty(message = "El campo bank no puede ser vacio")
    private String bank;
}
