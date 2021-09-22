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
public class OrderDTO {

    @ApiModelProperty(value = "El código de referencia de la orden.", name = "referenceCode", dataType = "String", required = true, example = "6bbc7c2b-4216-46ec-861c-63839b5fe5ffs")
    @NotNull(message = "El campo referenceCode no puede ser nulo")
    @NotEmpty(message = "El campo referenceCode no puede ser vacio")
    public String referenceCode;

    @ApiModelProperty(value = "La descripción de la orden.", name = "description", dataType = "String", required = true, example = "pago test")
    @NotNull(message = "El campo description no puede ser nulo")
    @NotEmpty(message = "El campo description no puede ser vacio")
    public String description;

    @ApiModelProperty(value = "El idioma usado en los correos electrónicos ", name = "language", dataType = "String", required = true, example = "es")
    @NotNull(message = "El campo language no puede ser nulo")
    @NotEmpty(message = "El campo language no puede ser vacio")
    public String language;


    @ApiModelProperty(value = "La URL de notificación", name = "notifyUrl", dataType = "String", required = false, example = "http://www.tes.com/confirmation")
    public String notifyUrl;

    @ApiModelProperty(value = "La dirección de envío.", name = "shippingAddressDTO",  required = false)
    public ShippingAddressDTO shippingAddressDTO;

    @ApiModelProperty(value = "Datos del comprador.", name = "buyerDTO",  required = true)
    public BuyerDTO buyerDTO;

    @ApiModelProperty(value = "Valores o montos asociados a la orden", name = "additionalValuesDTO", required = true)
    public AdditionalValuesDTO additionalValuesDTO;


}
