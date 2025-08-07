package com.orderapp.Online_Order_App.service;

import com.orderapp.Online_Order_App.dto.BillResponse;
import com.orderapp.Online_Order_App.dto.OrderRequest;
import com.orderapp.Online_Order_App.dto.PaymentDto;

public interface OrderService {

	BillResponse generatedBill(OrderRequest orderRequest);
	
	String payAndPlaceOrder(PaymentDto Payment);

}
