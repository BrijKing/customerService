package com.example.customerService.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customerService.model.CustomerPdf;

public interface CustomerPdfRepository extends MongoRepository<CustomerPdf , String> {
	
	
	Optional<CustomerPdf> findByEmail(String email);
	

}
