package com.orderapp.Online_Order_App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.entity.Order;
import com.orderapp.Online_Order_App.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	@Query("SELECT r.food FROM Restaurant r WHERE r.id = :restaurantId")
	List<Food> findFoodByRestaurantId(@Param(value = "restaurant")int id);
	
	@Query("SELECT r.orders FROM Restaurant r WHERE r.id = :restaurantId")
	

	List<Order> findOrdersByRestaurant(@Param(value = "restaurantId")int id);

	

	

}
