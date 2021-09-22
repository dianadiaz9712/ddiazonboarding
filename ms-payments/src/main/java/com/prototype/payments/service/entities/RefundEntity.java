package com.prototype.payments.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RefundEntity {

    private TransactionRefundEntity transactionRefundEntity;

    private final String language;

    private final String command;

    private MerchantEntity merchantEntity;
    private boolean test;

}
