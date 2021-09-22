package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyerEntity {

    public String idCustomer;
    private String merchantBuyerId;
    private String fullName;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private ShippingAddressEntity shippingAddressEntity;

}
