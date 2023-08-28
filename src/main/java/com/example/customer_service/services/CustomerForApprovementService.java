package com.example.customer_service.services;

import java.util.List;

import com.example.customer_service.dtos.CombinedCustomerDTO;
import com.example.customer_service.dtos.PendingCustomersDto;


public interface CustomerForApprovementService {
	
	 List<CombinedCustomerDTO>  combineCollections();

	 List<PendingCustomersDto> getAllPendingCustomers();

}
