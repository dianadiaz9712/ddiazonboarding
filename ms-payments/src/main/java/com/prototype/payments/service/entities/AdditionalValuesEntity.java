package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalValuesEntity {

    private TxValueEntity txValueEntity;

    private TxTaxEntity txTaxEntity;

    private TxTaxReturnBaseEntity txTaxReturnBaseEntity;
}
