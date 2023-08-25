package com.example.customer_service.services;

import com.example.customer_service.custom_exception.CustomerPdfNotFoundException;
import com.example.customer_service.model.CustomerForApprovement;

public interface CustomerPdfService {
	
	CustomerForApprovement addCustomerPdf(CustomerForApprovement customerForApprovement);
	
	CustomerForApprovement getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException;

}
