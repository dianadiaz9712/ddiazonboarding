package com.prototype.payments.thirdyparty.payu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Refund {

    private String language;
    private String command;

    private Merchant merchant;
    @JsonProperty("transaction")
    private TransactionRefund transactionRefund;

    private boolean test;
}
