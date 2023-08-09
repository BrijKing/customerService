package com.example.customer_service.Services;

import java.util.List;

import com.example.customer_service.dtos.CombinedCustomerDTO;
import com.example.customer_service.model.Customer;

public interface CustomerForApprovementService {
	
	 List<CombinedCustomerDTO>  combineCollections();
	

}
