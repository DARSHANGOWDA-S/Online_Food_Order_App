package com.orderapp.Online_Order_App.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	T data;

}
