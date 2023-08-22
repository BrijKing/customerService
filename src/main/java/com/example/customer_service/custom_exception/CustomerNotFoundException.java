package com.example.customer_service.custom_exception;

public class CustomerNotFoundException extends Exception {
	
	public CustomerNotFoundException() {
		super("Sorry No Customer Found With that email 😞");
	}

}
