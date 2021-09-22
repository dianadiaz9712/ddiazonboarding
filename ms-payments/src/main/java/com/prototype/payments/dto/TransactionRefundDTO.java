package com.prototype.payments.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ApiModel
@Validated
public class TransactionRefundDTO {


    @ApiModelProperty(value = "Para anulñacion y reembolso", name = "type", dataType = "String", required = true, example = "REFUND")
    @NotNull(message = "El campo type no puede ser nulo")
    @NotEmpty(message = "El campo type no puede ser vacio")
    public String type;

    @ApiModelProperty(value = "Motivo por el cual se solicita el reembolso o la anulación de la transacción.", name = "reason", dataType = "String", required = true, example = "Cancelar la transaccion")
    @NotNull(message = "El campo reason no puede ser nulo")
    @NotEmpty(message = "El campo reason no puede ser vacio")
    public String reason;

    @ApiModelProperty(value = "El identificador de la transacción relacionada", name = "parentTransactionId", dataType = "String", required = true, example = "47ac531a-8c78-4a1d-b012-da343ee3ac2b")
    @NotNull(message = "El campo parentTransactionId no puede ser nulo")
    @NotEmpty(message = "El campo parentTransactionId no puede ser vacio")
    @NotBlank(message = "El campo parentTransactionId no puede ser vacio")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", message = "El parámetro parentTransactionId debe contener un formato válido")
    public String parentTransactionId;

    @ApiModelProperty(value = "Los datos de la orden.", name = "orderRefundDTO", required = true)
    @Valid
    private OrderRefundDTO orderRefundDTO;
}
