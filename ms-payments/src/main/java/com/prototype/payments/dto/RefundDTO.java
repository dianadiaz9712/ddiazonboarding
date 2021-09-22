package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class RefundDTO {

    @ApiModelProperty(value = "Datos de la transaccion", name = "transactionRefundDTO", required = true)
    @NotNull(message = "El campo transactionRefundDTO no puede ser nulo")
    @Valid
    private TransactionRefundDTO transactionRefundDTO;

    @ApiModelProperty(value = "Indicador si es una petición de prueba", name = "test", dataType = "boolean", required = true, example = "true")
    @NotNull(message = "El campo test no puede ser nulo")
    public boolean test;

}
