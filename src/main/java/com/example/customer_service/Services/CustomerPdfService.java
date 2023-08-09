package com.example.customer_service.Services;

import com.example.customer_service.customExceptions.CustomerPdfNotFoundException;
import com.example.customer_service.model.CustomerPdf;

public interface CustomerPdfService {
	
	CustomerPdf addCustomerPdf(CustomerPdf customerPdf);
	
	CustomerPdf getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException;

}
