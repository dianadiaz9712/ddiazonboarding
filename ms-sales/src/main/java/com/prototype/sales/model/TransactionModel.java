package com.prototype.sales.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "transaction")
@Entity
@Getter
@Setter
public class TransactionModel extends Auditable {
    @Id
    @Column(name = "idtransaction", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idcustomer", nullable = false)
    private CustomeModel customer;

    @Column(name = "idpayment", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID idPayment;

    @Column(name = "referencecode")
    private String referenceCode;

    @Column(name = "description")
    private String description;

    @Column(name = "signature")
    private String signature;

    @Column(name = "shippingaddress")
    private String shippingAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "department")
    private String department;

    @Column(name = "country")
    private String country;

    @Column(name = "postalcode")
    private String postalCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "basevalue", nullable = false, precision = 131089)
    private float baseValue;

    @Column(name = "taxvalue", nullable = false, precision = 131089)
    private float taxValue;

    @Column(name = "totalvalue", nullable = false, precision = 131089)
    private float totalValue;

    @Column(name = "state")
    private String state;

    @Column(name = "reason")
    private String reason;

    @Column(name = "parenttransactionid")
    private UUID parentTransactionId;

    @Column(name = "platform", nullable = false)
    private String platform;

    @Column(name = "datetransaction", nullable = false)
    private Date dateTransaction;


}