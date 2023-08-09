package com.example.customer_service.ServicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer_service.Services.CustomerPdfService;
import com.example.customer_service.customExceptions.CustomerPdfNotFoundException;
import com.example.customer_service.model.CustomerPdf;
import com.example.customer_service.repositories.CustomerPdfRepository;

@Service
public class CustomerPdfServiceImp implements CustomerPdfService {
	
	@Autowired
	CustomerPdfRepository customerPdfRepository;

	@Override
	public CustomerPdf addCustomerPdf(CustomerPdf customerPdf) {
		// TODO Auto-generated method stub
		return customerPdfRepository.save(customerPdf);
	}

	@Override
	public CustomerPdf getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException {
		// TODO Auto-generated method stub
		return customerPdfRepository.findByEmail(email).orElseThrow(() -> new CustomerPdfNotFoundException());
	}
	
	

}
