package com.example.customerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerService.Services.CustomerService;
import com.example.customerService.model.Customer;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		
		try {
			customerService.addCustomer(customer);
			
			return new ResponseEntity<String>("customer added successfully!!",HttpStatus.CREATED);
		} catch (Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
		
	}
	

}
