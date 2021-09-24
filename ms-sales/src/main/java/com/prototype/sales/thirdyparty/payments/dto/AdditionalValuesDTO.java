package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalValuesDTO {

    public TxValueDTO txValueDTO;

    public TxTaxDTO txTaxDTO;

    public TxTaxReturnBaseDTO txTaxReturnBaseDTO;
}
