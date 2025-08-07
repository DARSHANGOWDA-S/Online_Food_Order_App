package com.orderapp.Online_Order_App.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.orderapp.Online_Order_App.dto.ResponseStructure;
import com.orderapp.Online_Order_App.entity.Restaurant;
import com.orderapp.Online_Order_App.service.RestaurantService;

@RestController
@RequestMapping("/restaurant/api")
public class RestaurantController {
    
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<Restaurant>> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant response = restaurantService.createRestaurant(restaurant);

        ResponseStructure<Restaurant> apiResponse = new ResponseStructure<>();
        apiResponse.setData(response);
        apiResponse.setMessage("Request object successful");
        apiResponse.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseStructure<Restaurant>> getById(@PathVariable Integer id) {
       
    	Restaurant response = restaurantService.getById(id);
        ResponseStructure<Restaurant> apiResponse = new ResponseStructure<>();
        apiResponse.setData(response);
        apiResponse.setMessage("Request object Found");
        apiResponse.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    @GetMapping("/getall")
    public ResponseEntity<ResponseStructure<List<Restaurant>>> getAllRestaurants() {
       
    	List<Restaurant> response = restaurantService.getAllRestaurants();
        ResponseStructure<List<Restaurant>> apiResponse = new ResponseStructure<>();
        apiResponse.setData(response);
        apiResponse.setMessage("All restaurants fetched successfully");
        apiResponse.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurantById(@PathVariable Integer id, @RequestBody Restaurant updatedRestaurant) {
        
        Restaurant update = restaurantService.updateRestaurantById(id, updatedRestaurant);
        ResponseStructure<Restaurant> apiResponse = new ResponseStructure<>();
        apiResponse.setData(update);
        apiResponse.setMessage("Request object Updated");
        apiResponse.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{restaurantId}/assignFood")
	public ResponseEntity<ResponseStructure<Restaurant>> assignFood(@PathVariable Integer restaurantId,@RequestBody Set<Integer> food){
		Restaurant restaurant = restaurantService.assignFood(restaurantId, food);
		ResponseStructure<Restaurant> apiResponse = new ResponseStructure<>();
		apiResponse.setData(restaurant);
		apiResponse.setMessage("Assigned sucessfully");
		apiResponse.setStatusCode(HttpStatus.OK.value());
		
		return ResponseEntity.ok(apiResponse);
	}

    }

    

