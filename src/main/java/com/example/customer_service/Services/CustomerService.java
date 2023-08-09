package com.example.customer_service.Services;

import java.util.List;

import com.example.customer_service.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	

}
