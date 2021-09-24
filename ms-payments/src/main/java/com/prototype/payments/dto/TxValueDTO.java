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
public class TxValueDTO {
    @ApiModelProperty(value = "El código ISO de la moneda asociada al monto", name = "value", dataType = "int", required = true, example = "20000")
    @NotNull(message = "El campo value no puede ser nulo")
    @NotEmpty(message = "El campo value no puede ser vacio")
    private int value;

    @ApiModelProperty(value = "El código ISO de la moneda asociada al monto", name = "currency", dataType = "String", required = true , example = "COP")
    @NotNull(message = "El campo currency no puede ser nulo")
    @NotEmpty(message = "El campo currency no puede ser vacio")
    private String currency;
}
