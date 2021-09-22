package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payer {
    private String merchantPayerId;
    private String fullName;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private BillingAddress billingAddress;
}
