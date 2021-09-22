package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Buyer {
    private String merchantBuyerId;
    private String fullName;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private ShippingAddress shippingAddress;
}
