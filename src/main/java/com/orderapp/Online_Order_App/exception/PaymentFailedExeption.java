package com.orderapp.Online_Order_App.exception;

import com.orderapp.Online_Order_App.exception.PaymentFailedExeption;

public class PaymentFailedExeption extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public PaymentFailedExeption(String message) {
        super(message);
    }
}
