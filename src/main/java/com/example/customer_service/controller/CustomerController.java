package com.example.customer_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer_service.dtos.CustomerDto;
import com.example.customer_service.model.Customer;
import com.example.customer_service.services.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customer){
		
		try {
			customerService.addCustomer(customer);
			
			return new ResponseEntity<>("customer added successfully!!",HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam int pageNo){
		
		return new ResponseEntity<>(customerService.getPaginatedResults(pageNo),HttpStatus.OK);
		
	}
	
	@GetMapping("/getCustomer/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email){
		
		return new ResponseEntity<>(customerService.findCustomerByEmai(email),HttpStatus.FOUND);
	}
	

}
