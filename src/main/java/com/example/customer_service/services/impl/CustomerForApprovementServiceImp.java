package com.example.customer_service.services.impl;

import java.util.List;

import com.example.customer_service.dtos.PendingCustomersDto;
import com.example.customer_service.repositories.CustomerPdfRepository;
import com.example.customer_service.services.CustomerPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Service;

import com.example.customer_service.dtos.CombinedCustomerDTO;
import com.example.customer_service.services.CustomerForApprovementService;

@Service
public class CustomerForApprovementServiceImp implements CustomerForApprovementService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    private CustomerPdfRepository customerPdfRepository;

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

    @Override
    public List<PendingCustomersDto> getAllPendingCustomers() {

        return customerPdfRepository.findAll().stream().map(customer -> {
            PendingCustomersDto pendingCustomersDto = new PendingCustomersDto();
            if (!customer.isSigned()) {
                pendingCustomersDto.setEmail(customer.getEmail());
                pendingCustomersDto.setSigned(customer.isSigned());
                pendingCustomersDto.setSignBy(customer.getSignBy());
                return pendingCustomersDto;
            } else return null;
        }).filter(pendingCustomersDto -> pendingCustomersDto != null).toList();
    }

    @Override
    public void approveCustomer(String email) {
        customerPdfRepository.findByEmail(email).ifPresent(customerPdf -> {
            customerPdf.setSigned(true);
            customerPdfRepository.save(customerPdf);
        });

    }

    @Override
    public void rejectCustomer(String email) {
        customerPdfRepository.findByEmail(email).ifPresent(customerPdf -> {
            customerPdf.setSigned(false);
            customerPdfRepository.save(customerPdf);
        });


    }

}
