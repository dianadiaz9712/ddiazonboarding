package com.prototype.payments.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "bank")
@Entity
@Setter
@Getter
public class BankModel extends Auditable{

    @Id
    @Column(name = "idbank", columnDefinition = "uuid")
    @Type(type = "pg-uuid")
    private UUID idBank;

    @Column(name = "namebank")
    private String nameBank;

}