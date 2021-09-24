package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayerDTO {

    public String merchantPayerId;

    public String fullName;

    public String emailAddress;

    public String contactPhone;

    public String dniNumber;

    public BillingAddressDTO billingAddressDTO;
}
