package com.example.customerService.Services;

import com.example.customerService.customExceptions.CustomerPdfNotFoundException;
import com.example.customerService.model.CustomerPdf;

public interface CustomerPdfService {
	
	CustomerPdf addCustomerPdf(CustomerPdf customerPdf);
	
	CustomerPdf getCustomerPdfByCustomerEmail(String email) throws CustomerPdfNotFoundException;

}
