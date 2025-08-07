package com.orderapp.Online_Order_App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillResponse {
	private String restaurantName;
	private String orderSummary;
	private float tottlePrize;
}
