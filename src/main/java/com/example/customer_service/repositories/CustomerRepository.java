package com.example.customer_service.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer_service.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	List<Customer> findByEmail(String email);
	

}
