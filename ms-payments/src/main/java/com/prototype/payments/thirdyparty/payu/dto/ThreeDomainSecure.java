package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreeDomainSecure {
    private boolean embedded;
    private String eci;
    private String cavv;
    private String xid;
    private String directoryServerTransactionId;
}
