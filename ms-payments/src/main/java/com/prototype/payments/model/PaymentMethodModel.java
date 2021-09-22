package com.prototype.payments.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "paymentmethod")
@Entity
@Setter
@Getter
public class PaymentMethodModel extends Auditable {

    @Id
    @Column(name = "idpaymentmethod", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

}