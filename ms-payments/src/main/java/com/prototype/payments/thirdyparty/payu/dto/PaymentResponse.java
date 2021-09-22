package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {

    private String code;
    private String error;

    private TransactionResponse transactionResponse;
}
