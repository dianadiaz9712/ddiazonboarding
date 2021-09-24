package com.prototype.sales.service.entities;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CustomerEntity {

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
}
