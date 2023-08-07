package com.example.customerService.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.customerService.customExceptions.CustomerPdfNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(CustomerPdfNotFoundException.class)
	public ResponseEntity<?> myMessage(CustomerPdfNotFoundException c){
		return new ResponseEntity<>(c.getMessage(),HttpStatus.NOT_FOUND);
	}

}
