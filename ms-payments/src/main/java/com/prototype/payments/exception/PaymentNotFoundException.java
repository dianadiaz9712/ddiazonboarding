package com.prototype.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NO_CONTENT)
public class PaymentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2675180781575463758L;

	public PaymentNotFoundException(String message) {
		super(message);
	}

}
