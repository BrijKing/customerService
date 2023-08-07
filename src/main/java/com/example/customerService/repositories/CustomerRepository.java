package com.example.customerService.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customerService.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
