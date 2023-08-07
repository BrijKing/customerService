package com.example.customerService.Services;

import java.util.List;

import com.example.customerService.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	

}
