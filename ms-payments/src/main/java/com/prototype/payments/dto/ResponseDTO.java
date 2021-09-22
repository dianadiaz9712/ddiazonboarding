package com.prototype.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private String code;
    private String error;

    private TransactionResponseDTO transactionResponseDTO;
}
