package com.example.customer_service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.custom_exception.CustomerPdfNotFoundException;
import com.example.customer_service.model.CustomerPdf;
import com.example.customer_service.repositories.CustomerPdfRepository;
import com.example.customer_service.services.CustomerPdfService;

@Service
public class CustomerPdfServiceImp implements CustomerPdfService {
	
	@Autowired
	CustomerPdfRepository customerPdfRepository;

	@Override
	public CustomerPdf addCustomerPdf(CustomerPdf customerPdf) {

		return customerPdfRepository.save(customerPdf);
	}

	@Override
	public CustomerPdf getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException {

		return customerPdfRepository.findByEmail(email).orElseThrow(CustomerPdfNotFoundException::new);

	}
	
	

}
