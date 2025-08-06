package com.orderapp.Online_Order_App.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                                                    //no need of the writing the getter and setter it is use to reduce the boilerplate code
@Entity   
@AllArgsConstructor                 
@NoArgsConstructor
public class Restaurant {
	
	
	@Id                                                            //auto generate the values
	@GeneratedValue(strategy = GenerationType.AUTO)                 //auto generate the unique values         
	private int id;
	private String name;
	private String address;
	private String contactnumber;
	private String email;
	@CreationTimestamp
	private LocalDate createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToMany
	@JoinTable(
	    name = "restaurant_food",
	    joinColumns = @JoinColumn(name = "id_resturent"),
	    inverseJoinColumns = @JoinColumn(name = "id_food")
	)
	private List<Food> food;
    
	@OneToMany(mappedBy = "restaurant")
	private List<Order> orders;

}
