package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRefundEntity {

    private OrderRefundEntity orderRefundEntity;
    private String type;
    private String reason;
    private String parentTransactionId;
}
