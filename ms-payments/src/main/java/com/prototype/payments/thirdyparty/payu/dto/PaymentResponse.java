package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PaymentResponse {

    private String code;
    private String error;
    private UUID idPayment;
    private TransactionResponse transactionResponse;
}
