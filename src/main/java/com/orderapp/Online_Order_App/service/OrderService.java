package com.orderapp.Online_Order_App.service;

import com.orderapp.Online_Order_App.dto.BillResponse;
import com.orderapp.Online_Order_App.dto.OrderRequest;
import com.orderapp.Online_Order_App.dto.PaymentDto;
import com.orderapp.Online_Order_App.entity.Order;
import com.orderapp.Online_Order_App.entity.OrderStatus;

public interface OrderService {

	BillResponse generatedBill(OrderRequest orderRequest);
	
	String payAndPlaceOrder(PaymentDto Payment);
	
	void deleteOrder(Integer id);
	
	Order getOrder(Integer id);
	
	Order updateStatusByAdmin(OrderStatus status,Integer id);
	
	String cancelOrder(Integer id);
	

}
