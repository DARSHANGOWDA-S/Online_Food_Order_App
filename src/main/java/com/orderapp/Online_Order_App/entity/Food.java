package com.orderapp.Online_Order_App.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import lombok.Data;

@Data                                           
@Entity   
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonIgnore
	@ManyToMany
	private String name;
	private String describtion;
	private Float price;
	
	
	
	@ManyToMany
	List<Restaurant> restaurant;

}
