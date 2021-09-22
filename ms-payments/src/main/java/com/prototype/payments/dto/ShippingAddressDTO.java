package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class ShippingAddressDTO {
    @ApiModelProperty(value = "Primera línea de la dirección.", name = "street1", dataType = "String", required = false, example = "Calle")
    private String street1;

    @ApiModelProperty(value = "Segunda línea de la dirección.", name = "street2", dataType = "String", required = false, example = "Calle")
    private String street2;

    @ApiModelProperty(value = "Ciudad de la dirección.", name = "city", dataType = "String", required = false, example = "Bogota")
    private String city;

    @ApiModelProperty(value = "Estado o departamento de la dirección.", name = "state", dataType = "String", required = false, example = "Cundinamarca")
    private String state;

    @ApiModelProperty(value = "País de la dirección.", name = "country", dataType = "String", required = false, example =  "CO")
    private String country;

    @ApiModelProperty(value = "Código postal de la dirección.", name = "postalCode", dataType = "String", required = false, example = "250052")
    private String postalCode;

    @ApiModelProperty(value = "Teléfono asociado a la dirección.", name = "phone", dataType = "String", required = false, example = "8401707")
    private String phone;
}
