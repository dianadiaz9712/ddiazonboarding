package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResponseEntity {

    private String code;
    private String error;
    private UUID idPayment;
    private TransactionResponseEntity transactionResponseEntity;
}
