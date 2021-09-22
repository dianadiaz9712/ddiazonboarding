package com.prototype.payments.thirdyparty.payu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalValues {

	@JsonProperty("TX_VALUE") 
    private TxValue txValue;

    @JsonProperty("TX_TAX") 
    private TxTax txTax;

    @JsonProperty("TX_TAX_RETURN_BASE") 
    private TxTaxReturnBase txTaxReturnBase;
}
