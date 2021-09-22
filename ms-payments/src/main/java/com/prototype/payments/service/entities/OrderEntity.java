package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEntity {


	private int accountId;

  	private String language;

	private String referenceCode;
    private String description;
    private BuyerEntity buyerEntity;

    private String notifyUrl;
   

    private AdditionalValuesEntity additionalValuesEntity;
    private ShippingAddressEntity shippingAddressEntity;
}
