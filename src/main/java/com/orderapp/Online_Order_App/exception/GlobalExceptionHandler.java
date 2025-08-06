package com.orderapp.Online_Order_App.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.orderapp.Online_Order_App.dto.ResponseStructure;

@RestControllerAdvice             //it is represent the bean and it is the responsible for the exception thrown in the 
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>>noSuchElementException (NoSuchElementException exception){
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setData(exception.getMessage());
		response.setMessage("Exception created and handled");
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}

}
