package com.prototype.payments.service.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreeDomainSecureEntity {
    private boolean embedded;
    private String eci;
    private String cavv;
    private String xid;
    private String directoryServerTransactionId;
}
