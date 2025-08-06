package com.orderapp.Online_Order_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.Online_Order_App.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
