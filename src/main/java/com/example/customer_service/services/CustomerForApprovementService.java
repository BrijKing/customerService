package com.example.customer_service.services;

import java.util.List;

import com.example.customer_service.dtos.CombinedCustomerDTO;


public interface CustomerForApprovementService {
	
	 List<CombinedCustomerDTO>  combineCollections();
	

}
