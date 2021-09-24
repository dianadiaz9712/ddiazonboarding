package com.prototype.sales.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RefundRequestDTO {

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

    @ApiModelProperty(value = "El identificador de la orden asociada a la transacción.",name = "id", dataType = "long", example = "1401280038")
    @NotNull(message = "El campo id no puede ser nulo")
    private long orderId;
}
