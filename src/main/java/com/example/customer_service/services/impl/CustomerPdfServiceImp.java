package com.example.customer_service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.custom_exception.CustomerPdfNotFoundException;
import com.example.customer_service.model.CustomerForApprovement;
import com.example.customer_service.repositories.CustomerPdfRepository;
import com.example.customer_service.services.CustomerPdfService;

@Service
public class CustomerPdfServiceImp implements CustomerPdfService {
	
	@Autowired
	CustomerPdfRepository customerPdfRepository;

	@Override
	public CustomerForApprovement addCustomerPdf(CustomerForApprovement customerForApprovement) {

		return customerPdfRepository.save(customerForApprovement);
	}

	@Override
	public CustomerForApprovement getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException {

		return customerPdfRepository.findByEmail(email).orElseThrow(CustomerPdfNotFoundException::new);

	}
	
	

}
