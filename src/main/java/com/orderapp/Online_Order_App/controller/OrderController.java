package com.orderapp.Online_Order_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.Online_Order_App.dto.BillResponse;
import com.orderapp.Online_Order_App.dto.OrderRequest;
import com.orderapp.Online_Order_App.dto.ResponseStructure;
import com.orderapp.Online_Order_App.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/generate-bill")
	public ResponseEntity<ResponseStructure<BillResponse>> generatedBill(@RequestBody OrderRequest orderRequest){
		BillResponse response = orderService.generatedBill(orderRequest);
		ResponseStructure<BillResponse> apiResponse = new ResponseStructure<>();
		apiResponse.setData(response);
		apiResponse.setMessage("Bill has been generated");
		apiResponse.setStatusCode(HttpStatus.CREATED.value());
		
		
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
		}
	

}
