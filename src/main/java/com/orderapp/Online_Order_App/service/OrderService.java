package com.orderapp.Online_Order_App.service;

import com.orderapp.Online_Order_App.dto.BillResponse;
import com.orderapp.Online_Order_App.dto.OrderRequest;

public interface OrderService {

	BillResponse generatedBill(OrderRequest orderRequest);
	
	String payAndPlaceOrder(Payment)

}
