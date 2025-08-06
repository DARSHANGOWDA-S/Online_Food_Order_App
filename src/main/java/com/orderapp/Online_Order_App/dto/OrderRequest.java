package com.orderapp.Online_Order_App.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {
	private List<OrderItemRequest> orderItem;
	private Integer restaurantId;

}
