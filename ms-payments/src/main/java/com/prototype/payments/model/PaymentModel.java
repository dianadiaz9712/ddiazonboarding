package com.prototype.payments.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "payment")
@Entity
@Setter
@Getter
public class PaymentModel extends Auditable {
    @Id
    @GeneratedValue
    @Column(name = "idpayment", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "idpaymentmethod")
    private PaymentMethodModel paymentMethodModel;

    @ManyToOne
    @JoinColumn(name = "idcurrency")
    private CurrencyModel currencyModel;

    @ManyToOne
    @JoinColumn(name = "idcard")
    private CardModel cardModel;

    @Column(name = "state", nullable = false)
    private String state;

}