package com.example.customer_service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.dtos.CustomerDto;
import com.example.customer_service.model.Customer;
import com.example.customer_service.repositories.CustomerRepository;
import com.example.customer_service.services.CustomerService;


@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(CustomerDto customer) {
		
		Customer c = Customer.builder()
				.address(customer.getAddress())
				.email(customer.getEmail())
				.firstName(customer.getFirstName())
				.lastName(customer.getLastName())
				.mobileNumber(customer.getMobileNumber())
				
				.build();
		
		return customerRepository.save(c);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}

}
