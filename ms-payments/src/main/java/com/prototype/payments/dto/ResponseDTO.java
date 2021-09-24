package com.prototype.payments.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ResponseDTO {

    private String code;
    private String error;
    private UUID idPayment;
    private TransactionResponseDTO transactionResponseDTO;
}
