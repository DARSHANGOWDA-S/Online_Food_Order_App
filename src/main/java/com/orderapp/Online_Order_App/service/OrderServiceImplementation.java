package com.orderapp.Online_Order_App.service;

import org.springframework.stereotype.Service;

import com.orderapp.Online_Order_App.dto.BillResponse;
import com.orderapp.Online_Order_App.dto.OrderItemRequest;
import com.orderapp.Online_Order_App.dto.OrderRequest;
import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.entity.Restaurant;

@Service
public class OrderServiceImplementation implements OrderService {

	private final RestaurantService restaurantService = null;
	private final FoodService foodService = null;
	
	
	@Override
	public BillResponse generatedBill(OrderRequest orderRequest) {
		
		Restaurant restaurant = restaurantService.getById(orderRequest.getRestaurantId());
		StringBuilder summary = new StringBuilder();
		
		float totalPrice =  0;
		
		for(OrderItemRequest orderItem : orderRequest.getOrderItem()) {
			Food food = foodService.getFoodById(orderItem.getFoodId());
			float price = food.getPrice() * orderItem.getQuantity();
			totalPrice+=price;
			summary.append(food.getName()).append("X").append(orderItem.getQuantity()).append("=").append("price").append("\n");
			
		}
		return new BillResponse(restaurant.getName(),summary.toString(),totalPrice);
	}


	@Override
	public String payAndPlaceOrder() {
		
		//simulate payment
		if(payment.isPaymentSuccesful()) {
			
			
		}
		else {
			throw PaymentFailedException
		}
		return null;
	}
	

}
