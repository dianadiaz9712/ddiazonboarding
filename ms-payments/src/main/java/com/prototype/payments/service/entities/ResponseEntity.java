package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseEntity {

    private String code;
    private String error;
    private TransactionResponseEntity transactionResponseEntity;
}
