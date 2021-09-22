package com.prototype.payments.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Table(name = "card")
@Entity
@Setter
@Getter
public class CardModel extends Auditable {

    @Id
    @GeneratedValue
    @Column(name = "idcard", nullable = false, columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idbank")
    private BankModel bank;

    @Column(name = "idcustomer", nullable = false, columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID idCustomer;

    @Column(name = "tokencard")
    private String tokenCard;

    @Column(name = "codecard", nullable = false)
    private String codeCard;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "platform", nullable = false)
    private String platform;


}