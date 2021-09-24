package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {

    public OrderDTO orderDTO;

    public CreditCardDTO creditCardDTO;

    public boolean cardToken;

    public CreditCardTokenDTO creditCardTokenDTO;

    public PayerDTO payerDTO;

    public String type;

    public String paymentMethod;

    public String paymentCountry;

    public String ipAddress;

    public String cookie;

    public String userAgent;

    public ExtraParametersDTO extraParametersDTO;

    public String platform;

}
