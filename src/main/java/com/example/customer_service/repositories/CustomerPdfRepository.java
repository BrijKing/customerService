package com.example.customer_service.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer_service.model.CustomerPdf;

public interface CustomerPdfRepository extends MongoRepository<CustomerPdf , String> {
	
	
	Optional<CustomerPdf> findByEmail(String email);
	

}
