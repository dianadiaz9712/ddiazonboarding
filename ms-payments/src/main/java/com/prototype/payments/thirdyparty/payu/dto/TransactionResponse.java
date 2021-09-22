package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransactionResponse {

       private int orderId;
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
       private Date operationDate;

}
