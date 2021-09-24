package com.prototype.sales.thirdyparty.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponseDTO {

       private String orderId;
       private String transactionId;
       private String state;
       private String paymentNetworkResponseCode;
       private String paymentNetworkResponseErrorMessage;
       private String trazabilityCode;
       private String authorizationCode;
       private String pendingReason;
       private String responseCode;
       private String errorCode;
       private String responseMessage;
       private String transactionDate;
       private String transactionTime;
       private String operationDate;
       private String extraParameters;
}
