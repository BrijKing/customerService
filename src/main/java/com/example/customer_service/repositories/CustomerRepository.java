package com.example.customer_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customer_service.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
