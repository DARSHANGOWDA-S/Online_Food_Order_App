package com.orderapp.Online_Order_App.service;

import java.util.List;
import java.util.Set;

import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.entity.Order;
import com.orderapp.Online_Order_App.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant createRestaurant(Restaurant  restaurant);

	Restaurant getById(Integer id);
	
	List<Restaurant> getAllRestaurants();

	Restaurant updateRestaurantById(Integer id, Restaurant updatedRestaurant);

	void deleteRestaurant(Integer id);

	Restaurant assignFood(Integer restaurantId, Set<Integer> food);
	
	List<Food> findFoodByRestaurantId(Integer id);
	
	List<Order> findOrdersByRestaurantId(Integer id);
	
	


}
