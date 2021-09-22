package com.prototype.payments.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiModel
public class TransactionDTO {

    @ApiModelProperty(value = "Datos de la orden", name = "orderDTO", required = true)
    @Valid
    public OrderDTO orderDTO;

    @ApiModelProperty(value = "Los datos de la tarjeta de crédito.", name = "creditCardDTO", required = false)
    @Valid
    public CreditCardDTO creditCardDTO;

    @ApiModelProperty(value = "Indicador si se hace pago con tarjeta con token", name = "cardToken", required = true)
    @NotNull(message = "El campo cardToken no puede ser nulo")
    @NotEmpty(message = "El campo cardToken no puede ser vacio")
    public boolean cardToken;

    @ApiModelProperty(value = "Los datos de la tarjeta de crédito .", name = "creditCardTokenDTO", required = false)
    @Valid
    public CreditCardTokenDTO creditCardTokenDTO;

    @ApiModelProperty(value = "Datos del pagador.", name = "payerDTO", required = true)
    @NotNull(message = "El campo payerDTO no puede ser nulo")
    @NotEmpty(message = "El campo payerDTO no puede ser vacio")
    @Valid
    public PayerDTO payerDTO;

    @ApiModelProperty(value = "Para autorización y captura", name = "type", dataType = "String", required = true, example = "AUTHORIZATION_AND_CAPTURE")
    @NotNull(message = "El campo type no puede ser nulo")
    @NotEmpty(message = "El campo type no puede ser vacio")
    public String type;

    @ApiModelProperty(value = "El medio de pago.", name = "paymentMethod", dataType = "String", required = true, example = "MASTERCARD")
    @NotNull(message = "El campo paymentMethod no puede ser nulo")
    @NotEmpty(message = "El campo paymentMethod no puede ser vacio")
    public String paymentMethod;

    @ApiModelProperty(value = "País de pago", name = "paymentCountry", dataType = "String", required = true, example = "CO")
    @NotNull(message = "El campo paymentCountry no puede ser nulo")
    @NotEmpty(message = "El campo paymentCountry no puede ser vacio")
    public String paymentCountry;


    @ApiModelProperty(value = "La dirección IP del dispositivo desde donde se realiza la transacción.", name = "ipAddress", dataType = "String", required = true, example = "10.100.26.24")
    @NotNull(message = "El campo ipAddress no puede ser nulo")
    @NotEmpty(message = "El campo ipAddress no puede ser vacio")
    public String ipAddress;

    @ApiModelProperty(value = "La cookie almacenada en el dispositivo", name = "cookie", dataType = "String", required = true, example = "cookie_d0o9k4joe3")
    @NotNull(message = "El campo cookie no puede ser nulo")
    @NotEmpty(message = "El campo cookie no puede ser vacio")
    public String cookie;

    @ApiModelProperty(value = "El user agent del navegador desde donde se realiza la transacción", name = "userAgent", dataType = "String", required = true, example = "Jmeter Agent 2.9" )
    @NotNull(message = "El campo userAgent no puede ser nulo")
    @NotEmpty(message = "El campo userAgent no puede ser vacio")
    public String userAgent;

    @ApiModelProperty(value = "Contiene la información de un parámetro.", name = "extraParametersDTO", dataType = "String", required = false)
    public ExtraParametersDTO extraParametersDTO;

    @ApiModelProperty(value = "Plataforma de pago", name = "platform", dataType = "String", required = true, example = "PAYU")
    @NotNull(message = "El campo platform no puede ser nulo")
    @NotEmpty(message = "El campo platform no puede ser vacio")
    public String platform;

}
