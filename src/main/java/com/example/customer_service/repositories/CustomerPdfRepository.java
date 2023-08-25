package com.example.customer_service.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer_service.model.CustomerForApprovement;

public interface CustomerPdfRepository extends MongoRepository<CustomerForApprovement, String> {
	
	
	Optional<CustomerForApprovement> findByEmail(String email);
	

}
