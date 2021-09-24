package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class PayerDTO {


    @ApiModelProperty(value = "El nombre completo del pagador", name = "fullName", dataType = "String", required = true, example = "Patricia Martinez")
    @NotNull(message = "El campo fullName no puede ser nulo")
    @NotEmpty(message = "El campo fullName no puede ser vacio")
    private String fullName;

    @ApiModelProperty(value = "Correo electrónico del pagador", name = "emailAddress", dataType = "String", required = true, example = "dianadiaz9712@pauy.com")
    @NotNull(message = "El campo emailAddress no puede ser nulo")
    @NotEmpty(message = "El campo emailAddress no puede ser vacio")
    @Email(message = "El formato del correo no s valido")
    private String emailAddress;

    @ApiModelProperty(value = "Teléfono de contacto del pagador.\t", name = "contactPhone", dataType = "String", required = true, example = "6859954")
    @NotNull(message = "El campo contactPhone no puede ser nulo")
    @NotEmpty(message = "El campo contactPhone no puede ser vacio")
    private String contactPhone;

    @ApiModelProperty(value = "Tipo de documento del comprador.", name = "dniNumber", dataType = "String", required = true, example = "CC")
    @NotNull(message = "El campo dniType no puede ser nulo")
    @NotEmpty(message = "El campo dniType no puede ser vacio")
    private String dniType;

    @ApiModelProperty(value = "Tipo de documento del pagador.", name = "dniNumber", dataType = "String", required = true, example = "21546978797")
    @NotNull(message = "El campo dniNumber no puede ser nulo")
    @NotEmpty(message = "El campo dniNumber no puede ser vacio")
    private String dniNumber;

    @ApiModelProperty(value = "La dirección de cobro", name = "billingAddressDTO",  required = true)
    @NotNull(message = "El campo billingAddressDTO no puede ser nulo")
    @NotEmpty(message = "El campo billingAddressDTO no puede ser vacio")
    private BillingAddressDTO billingAddressDTO;
}
