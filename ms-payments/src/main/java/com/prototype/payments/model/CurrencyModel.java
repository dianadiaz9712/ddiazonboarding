package com.prototype.payments.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "currency")
@Entity
@Setter
@Getter
public class CurrencyModel extends Auditable {
    @Id
    @Column(name = "idcurrency", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "namecurrency", nullable = false)
    private String nameCurrency;


    @Column(name = "codecurrency", nullable = false)
    private String codeCurrency;

}