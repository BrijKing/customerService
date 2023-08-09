package com.example.customer_service.services;

import com.example.customer_service.custom_exception.CustomerPdfNotFoundException;
import com.example.customer_service.model.CustomerPdf;

public interface CustomerPdfService {
	
	CustomerPdf addCustomerPdf(CustomerPdf customerPdf);
	
	CustomerPdf getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException;

}
