package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class TxTaxDTO {
    @ApiModelProperty(value = "El código ISO de la moneda asociada al monto", name = "value", dataType = "int", required = true, example = "3193")
    @NotNull(message = "El campo value no puede ser nulo")
    public int value;

    @ApiModelProperty(value = "El código ISO de la moneda asociada al monto", name = "currency", dataType = "String", required = true , example = "COP")
    @NotNull(message = "El campo currency no puede ser nulo")
    public String currency;
}
