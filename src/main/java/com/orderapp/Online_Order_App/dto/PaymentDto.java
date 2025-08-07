package com.orderapp.Online_Order_App.dto;

import java.util.List;

import lombok.Data;

@Data
public class PaymentDto {
	private List<OrderItemRequest> orderItems;
	private boolean isPaymentSuccesful;

}
