package com.prototype.sales.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "transactiondetail")
@Entity
@Setter
@Getter
public class TransactionDetail extends Auditable {
    @Id
    @Column(name = "idtransactiondetail", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idtransaction", nullable = false)
    private TransactionModel idTransaction;

    @Column(name = "idproduct", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID idProduct;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unitvalue", nullable = false, precision = 131089)
    private float unitValue;

    @Column(name = "basevalue", nullable = false, precision = 131089)
    private float baseValue;

    @Column(name = "taxvalue", nullable = false, precision = 131089)
    private float taxValue;

    @Column(name = "totalvalue", nullable = false, precision = 131089)
    private float totalvalue;


}