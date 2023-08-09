package com.example.customerService.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerService.Services.CustomerForApprovementService;
import com.example.customerService.Services.CustomerPdfService;
import com.example.customerService.Services.SavePdfService;
import com.example.customerService.customExceptions.CustomerPdfNotFoundException;
import com.example.customerService.customExceptions.S3FileSavingException;
import com.example.customerService.dtos.CombinedCustomerDTO;
import com.example.customerService.dtos.CustomerForApprovemetnDto;
import com.example.customerService.model.Customer;
import com.example.customerService.model.CustomerPdf;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("customer/forApprovement")
public class CustomerForApprovementController {

	@Autowired
	CustomerPdfService customerPdfService;
	
	@Autowired
	CustomerForApprovementService customerForApprovementService;

	@Autowired
	SavePdfService savePdfService;

	@PostMapping("/add")
	public ResponseEntity<String> addCustomerPdf(@ModelAttribute CustomerForApprovemetnDto customerForApprovemetnDto)
			throws IOException, S3FileSavingException {

		savePdfService.savePdf(customerForApprovemetnDto);
		return new ResponseEntity<String>("customer added successfully!!", HttpStatus.CREATED);

	}

	@GetMapping("/getCustomer/{email}")
	public ResponseEntity<CustomerPdf> getCustomerPdfByCustomerEmail(@PathVariable String email)
			throws CustomerPdfNotFoundException {

		return new ResponseEntity<>(customerPdfService.getCustomerPdfByCustomerEmail(email), HttpStatus.FOUND);
	}
	
	@GetMapping("/getCombinedData")
	public ResponseEntity<List<CombinedCustomerDTO>> getCombinedData() {

		return new ResponseEntity<>(customerForApprovementService.combineCollections(), HttpStatus.FOUND);
	}

}
