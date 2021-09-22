package com.prototype.payments.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class PaymentRequestDTO {

    @ApiModelProperty(value = "Datos de la transaccion", name = "transactionDTO")
    public TransactionDTO transactionDTO;

    @ApiModelProperty(value = "Indicador si es una petición de prueba", name = "test", dataType = "boolean", required = true, example = "true")
    @NotNull(message = "El campo test no puede ser nulo")
    public boolean test;

}
