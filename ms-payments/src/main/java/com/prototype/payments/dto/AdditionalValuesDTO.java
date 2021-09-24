package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class AdditionalValuesDTO {
    @ApiModelProperty(value = "Monto total de la transacción", name = "txValueDTO",  required = true)
    @NotNull(message = "El campo txValueDTO no puede ser nulo")
    private TxValueDTO txValueDTO;

    @ApiModelProperty(value = "Valor del Iva", name = "txTaxDTO", required = true)
    @NotNull(message = "El campo txTaxDTO no puede ser nulo")
    @NotNull(message = "El campo txTaxDTO no puede ser nulo")
    private TxTaxDTO txTaxDTO;

    @ApiModelProperty(value = " Es el valor base sobre el cual se calcula el IVA", name = "txTaxReturnBaseDTO",  required = true)
    @NotNull(message = "El campo txTaxReturnBaseDTO no puede ser nulo")
    private TxTaxReturnBaseDTO txTaxReturnBaseDTO;
}
