package com.orderapp.Online_Order_App.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderapp.Online_Order_App.entity.Food;
import com.orderapp.Online_Order_App.entity.Order;
import com.orderapp.Online_Order_App.entity.Restaurant;
import com.orderapp.Online_Order_App.repository.RestaurantRepository;

@Service
public class RestaurantServiceImplementation implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	@Override
	public Restaurant getById(Integer id) {
		Optional<Restaurant> response = restaurantRepository.findById(id);
		
		if(response.isPresent()) {
			return response.get();
		}
		else {
			throw new NoSuchElementException("Restaurant with ID:"+id+"not found");
		}
		//return restaurantRZepository.findById(id).orElseThrow()->new NoSuchElementException("Restaurant with ID:"+id+"not found");
	}
	
	@Override
	public List<Restaurant> getAllRestaurants() {
	    return restaurantRepository.findAll();
	}
	
	@Override
	public Restaurant updateRestaurantById(Integer id,Restaurant updateRestaurant) {
		Restaurant exsting = getById(id);
		exsting.setAddress(updateRestaurant.getAddress());
		exsting.setContactnumber(updateRestaurant.getContactnumber());
		exsting.setEmail(updateRestaurant.getEmail());
		exsting.setName(updateRestaurant.getName());
		
		return restaurantRepository.save(exsting);
	}
	
	@Override
	public void deleteRestaurant(Integer id) {
	    Restaurant restaurant = getById(id);                         // Reuse your existing getById method for validation
	    restaurantRepository.delete(restaurant);
	}

	@Override
	public Restaurant assignFood(Integer restaurantId, Set<Integer> food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> findFoodByRestaurantId(Integer id) {
	    List<Food> food = restaurantRepository.findFoodByRestaurantId(id);

	    if (food == null || food.isEmpty()) {
	        throw new NoSuchElementException("Restaurant with ID: " + id + " not found or no food is assigned to the restaurant"
	        );
	    }

	    return food;
	}

	@Override
	public List<Order> findOrdersByRestaurantId(Integer id) {
		List<Order> orders = restaurantRepository.findOrdersByRestaurant(id);
		if(orders==null || orders.size()==0) {
			throw new NoSuchElementException("Restaurant with ID: " + id + " not found or no food is assigned to the restaurant");
		}
		return orders;
	}

}
