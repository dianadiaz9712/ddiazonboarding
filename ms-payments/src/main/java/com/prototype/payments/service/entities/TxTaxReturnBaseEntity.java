package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TxTaxReturnBaseEntity {
    private int value;
    private String currency;
}
