package com.orderapp.Online_Order_App.entity;

import java.util.List;

import org.apache.catalina.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
	
	private List<OrderItems> orderItems;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	private Double totalPrice;
	
	@JsonIgnore
	@ManyToOne
	private User user;
	

}
