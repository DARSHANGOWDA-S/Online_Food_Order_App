package com.orderapp.Online_Order_App.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.criteria.Order;
import lombok.Data;


@Data
@Entity
public class OrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Food food;
	
	@ManyToOne
	private Order order;
	
	private int quantity;
	 

}
