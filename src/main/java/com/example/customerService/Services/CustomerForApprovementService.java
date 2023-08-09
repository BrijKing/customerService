package com.example.customerService.Services;

import java.util.List;

import com.example.customerService.dtos.CombinedCustomerDTO;
import com.example.customerService.model.Customer;

public interface CustomerForApprovementService {
	
	 List<CombinedCustomerDTO>  combineCollections();
	

}
