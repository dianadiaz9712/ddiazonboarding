package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    public String referenceCode;

    public String description;

    public String language;

    public String notifyUrl;

    public ShippingAddressDTO shippingAddressDTO;

    public BuyerDTO buyerDTO;

    public AdditionalValuesDTO additionalValuesDTO;


}
