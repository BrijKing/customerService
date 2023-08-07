package com.example.customerService.ServicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerService.Services.CustomerService;
import com.example.customerService.model.Customer;
import com.example.customerService.repositories.CustomerRepository;


@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerRepository.findAll();
	}

}
