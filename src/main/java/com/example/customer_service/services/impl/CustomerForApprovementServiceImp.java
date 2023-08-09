package com.example.customer_service.services.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Service;

import com.example.customer_service.dtos.CombinedCustomerDTO;
import com.example.customer_service.services.CustomerForApprovementService;

@Service
public class CustomerForApprovementServiceImp implements CustomerForApprovementService {

	private final MongoTemplate mongoTemplate;
	
	public CustomerForApprovementServiceImp(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}



	@Override
	public List<CombinedCustomerDTO> combineCollections() {
		LookupOperation lookupOperation = LookupOperation.newLookup()
				.from("customerPdf")
				.localField("email") 
                .foreignField("email") 
                .as("pdfs");
		
		  Aggregation aggregation = Aggregation.newAggregation(
	                lookupOperation       
	        );

		  return mongoTemplate.aggregate(aggregation, "customer", CombinedCustomerDTO.class).getMappedResults();
	}

}
