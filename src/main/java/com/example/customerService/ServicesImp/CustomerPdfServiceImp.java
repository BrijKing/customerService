package com.example.customerService.ServicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerService.Services.CustomerPdfService;
import com.example.customerService.customExceptions.CustomerPdfNotFoundException;
import com.example.customerService.model.CustomerPdf;
import com.example.customerService.repositories.CustomerPdfRepository;

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
