package com.prototype.sales.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayerEntity {

    private String fullName;

    private String documentType;

    private String documentNumber;

    private String emailAddress;

    private String address;

    private String postalCode;

    private String contactPhone;

    private String state;

    private String city;

    private String country;

    private CardEntity cardEntity;

}
