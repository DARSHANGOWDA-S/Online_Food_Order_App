package com.orderapp.Online_Order_App.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Restaurant restaurant;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItems> orderItems;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private Double totalPrice;
	

}
