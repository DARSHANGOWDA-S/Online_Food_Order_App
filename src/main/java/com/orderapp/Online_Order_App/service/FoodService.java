package com.orderapp.Online_Order_App.service;

import java.util.List;

import com.orderapp.Online_Order_App.entity.Food;

public interface FoodService {

	Food createFood(Food food);
	
	Food getFoodById(Integer id);
	
	List<Food> getAllFood(int pageNum,int pagesize);
	
	Food updateFood(Food food,Integer id);
	
	void deleteFood(Integer id);


}
