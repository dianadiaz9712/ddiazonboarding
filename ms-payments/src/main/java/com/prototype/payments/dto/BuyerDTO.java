package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ApiModel
public class BuyerDTO {

    @ApiModelProperty(value = "Nombres completos del comprador.", name = "fullName", dataType = "String", required = true, example = "Diana Diaz")
    @NotNull(message = "El campo fullName no puede ser nulo")
    @NotEmpty(message = "El campo fullName no puede ser vacio")
    public String fullName;

    @ApiModelProperty(value = "Correo electrónico del comprador.", name = "emailAddress", dataType = "String", required = true, example = "diana.diaz@payu.com")
    @NotNull(message = "El campo emailAddress no puede ser nulo")
    @NotEmpty(message = "El campo emailAddress no puede ser vacio")
    @Email(message = "El formato del correo es incorrecto")
    public String emailAddress;

    @ApiModelProperty(value = "Teléfono de contacto del comprador", name = "contactPhone", dataType = "String", required = true , example = "3222419192")
    @NotNull(message = "El campo contactPhone no puede ser nulo")
    @NotEmpty(message = "El campo contactPhone no puede ser vacio")
    public String contactPhone;

    @ApiModelProperty(value = "Número de identificación del comprador.", name = "dniNumber", dataType = "String", required = true, example = "12338549756")
    @NotNull(message = "El campo dniNumber no puede ser nulo")
    @NotEmpty(message = "El campo dniNumber no puede ser vacio")
    public String dniNumber;

    @ApiModelProperty(value = "Dirección de envío del comprador.", name = "shippingAddressDTO", required = true)
    public ShippingAddressDTO shippingAddressDTO;

    @ApiModelProperty(value = "Indentificador del cliente.", name = "idCustomer", required = true)
    @NotNull(message = "El campo idCustomer no puede ser nulo")
    @NotEmpty(message = "El campo idCustomer no puede ser vacio")
    @Pattern(regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$", message = "El parámetro idCustomer debe contener un formato válido")
    public String idCustomer;
}
