package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class PayerEntity {

    @Value("${constant.merchantPayerId}")
    private String merchantPayerId;
    private String fullName;
    private String emailAddress;
    private String contactPhone;
    private String dniNumber;
    private BillingAddressEntity billingAddressEntity;
}
