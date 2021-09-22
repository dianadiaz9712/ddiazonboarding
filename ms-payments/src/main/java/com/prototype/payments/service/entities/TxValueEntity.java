package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TxValueEntity {
    private int value;
    private String currency;
}
