package com.prototype.sales.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "customer")
@Entity
@Getter
@Setter
public class CustomeModel extends Auditable {
    @Id
    @Column(name = "idcustomer", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "documenttype", nullable = false)
    private String documentType;

    @Column(name = "documentnumber", nullable = false)
    private String documentNumber;

    @Column(name = "emailadress", nullable = false)
    private String emailAdress;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column(name = "postalcode", nullable = false)
    private String postalCode;

    @Column(name = "contactphone", nullable = false)
    private String contactphone;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;


}