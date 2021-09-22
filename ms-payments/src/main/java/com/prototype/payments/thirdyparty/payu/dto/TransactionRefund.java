package com.prototype.payments.thirdyparty.payu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionRefund {

    @JsonProperty("order")
    private OrderRefund orderRefund;
    private String type;
    private String reason;
    private String parentTransactionId;
}
