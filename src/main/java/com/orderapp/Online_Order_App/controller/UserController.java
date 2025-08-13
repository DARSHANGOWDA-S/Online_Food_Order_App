package com.orderapp.Online_Order_App.controller;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.Online_Order_App.dto.ResponseStructure;
import com.orderapp.Online_Order_App.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/User/api")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody User user){
		User response = userService.createUser(user);

        ResponseStructure<User> apiResponse = new ResponseStructure<>();
        apiResponse.setData(response);
        apiResponse.setMessage("User is created");
        apiResponse.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<ResponseStructure<User>>(apiResponse, HttpStatus.CREATED);
    }
		
	}


