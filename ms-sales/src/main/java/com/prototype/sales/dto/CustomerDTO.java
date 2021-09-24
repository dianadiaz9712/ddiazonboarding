package com.prototype.sales.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class CustomerDTO {

    @ApiModelProperty(value = "Nombres completos del comprador.", name = "fullName", dataType = "String", required = true, example = "Diana Diaz")
    @NotNull(message = "El campo fullName no puede ser nulo")
    @NotEmpty(message = "El campo fullName no puede ser vacio")
    private String fullName;

    @ApiModelProperty(value = "Tipo de documento del pagador.", name = "dniNumber", dataType = "String", required = true, example = "CC")
    @NotNull(message = "El campo documentType no puede ser nulo")
    @NotEmpty(message = "El campo documentType no puede ser vacio")
    private String documentType;

    @ApiModelProperty(value = "Número  de documento del pagador.", name = "documentNumber", dataType = "String", required = true, example = "4165464674")
    @NotNull(message = "El campo documentNumber no puede ser nulo")
    @NotEmpty(message = "El campo documentNumber no puede ser vacio")
    private String documentNumber;

    @ApiModelProperty(value = "Correo electrónico del comprador.", name = "emailAddress", dataType = "String", required = true, example = "diana.diaz@payu.com")
    @NotNull(message = "El campo emailAddress no puede ser nulo")
    @NotEmpty(message = "El campo emailAddress no puede ser vacio")
    @Email(message = "El formato del correo es incorrecto")
    private String emailAddress;

    @ApiModelProperty(value = "Dirección de pagador.", name = "address", dataType = "String", required = false, example = "Calle")
    @NotNull(message = "El campo address no puede ser nulo")
    @NotEmpty(message = "El campo address no puede ser vacio")
    private String address;

    @ApiModelProperty(value = "Código postal de la dirección.", name = "postalCode", dataType = "String", required = false, example = "250052")
    @NotNull(message = "El campo contactPhone no puede ser nulo")
    @NotEmpty(message = "El campo contactPhone no puede ser vacio")
    private String postalCode;

    @ApiModelProperty(value = "Teléfono de contacto del comprador", name = "contactPhone", dataType = "String", required = true , example = "3222419192")
    @NotNull(message = "El campo contactPhone no puede ser nulo")
    @NotEmpty(message = "El campo contactPhone no puede ser vacio")
    private String contactPhone;

    @ApiModelProperty(value = "Estado o departamento de la dirección.", name = "state", dataType = "String", required = false, example = "Cundinamarca")
    @NotNull(message = "El campo state no puede ser nulo")
    @NotEmpty(message = "El campo state no puede ser vacio")
    private String state;

    @ApiModelProperty(value = "Ciudad de la dirección.", name = "city", dataType = "String", required = true, example = "Bogota")
    @NotNull(message = "El campo city no puede ser nulo")
    @NotEmpty(message = "El campo city no puede ser vacio")
    private String city;

    @ApiModelProperty(value = "País de la dirección.", name = "country", dataType = "String", required = false, example =  "CO")
    @NotNull(message = "El campo country no puede ser nulo")
    @NotEmpty(message = "El campo country no puede ser vacio")
    private String country;
}
