package com.prototype.sales.thirdyparty.payments.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRefundDTO {


    public String type;

    public String reason;

    public String parentTransactionId;

    private OrderRefundDTO orderRefundDTO;
}
