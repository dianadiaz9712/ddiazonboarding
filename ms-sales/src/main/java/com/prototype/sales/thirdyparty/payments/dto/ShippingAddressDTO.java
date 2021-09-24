package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingAddressDTO {

    private String street1;

    private String street2;

    private String city;

    private String state;

    private String country;

    private String postalCode;

    private String phone;
}
