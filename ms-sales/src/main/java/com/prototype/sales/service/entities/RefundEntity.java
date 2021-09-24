package com.prototype.sales.service.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundEntity {

    public String reason;

    public String parentTransactionId;

    private long orderId;
}
