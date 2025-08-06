package com.orderapp.Online_Order_App.service;

import java.util.List;

import com.orderapp.Online_Order_App.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant createRestaurant(Restaurant  restaurant);

	Restaurant getById(Integer id);
	
	List<Restaurant> getAllRestaurants();

	Restaurant updateRestaurantById(Integer id, Restaurant updatedRestaurant);

	void deleteRestaurant(Integer id);
	
	


}
