package com.orderapp.Online_Order_App.exception;

import com.orderapp.Online_Order_App.exception.PaymentFailedException;

public class PaymentFailedException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public PaymentFailedException(String message) {
        super(message);
    }
}
