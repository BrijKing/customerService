package com.example.customer_service.services;

import java.util.List;

import com.example.customer_service.dtos.CustomerDto;
import com.example.customer_service.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(CustomerDto customer);
	
	List<Customer> getAllCustomer();
	
	

}
