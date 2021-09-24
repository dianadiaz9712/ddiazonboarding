package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class TxTaxReturnBaseDTO {
    @ApiModelProperty(value = "El código ISO de la moneda asociada al monto", name = "value", dataType = "int", required = true, example = "16806")
    @NotNull(message = "El campo value no puede ser nulo")
    private int value;

    @ApiModelProperty(value = "El código ISO de la moneda asociada al monto", name = "currency", dataType = "String", required = true , example = "COP")
    @NotNull(message = "El campo currency no puede ser nulo")
    private String currency;
}
