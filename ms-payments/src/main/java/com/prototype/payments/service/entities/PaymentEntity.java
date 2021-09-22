package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentEntity {

    private  String language;
    private  String command;

    private MerchantEntity merchantEntity;
    private TransactionEntity transactionEntity;
    private boolean test;


}
