package com.prototype.payments.thirdyparty.payu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  Payment {

    private String language;
    private String command;
    private Merchant merchant;
    private Transaction transaction;
    private boolean test;

}
