package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class OrderRefundDTO {

    @ApiModelProperty(value = "El identificador de la orden asociada a la transacción.",name = "id", dataType = "long", example = "1401280038")
    @NotNull(message = "El campo id no puede ser nulo")
    @NotBlank(message = "El campo id no puede ser vacio")
    private long id;
}
