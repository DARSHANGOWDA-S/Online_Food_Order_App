package com.orderapp.Online_Order_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.Online_Order_App.entity.Order;

public interface OrderRepository  extends JpaRepository<Order, Integer>{

}
