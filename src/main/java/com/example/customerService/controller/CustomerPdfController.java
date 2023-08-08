package com.example.customerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerService.Services.CustomerPdfService;
import com.example.customerService.Services.SavePdfService;
import com.example.customerService.customExceptions.CustomerPdfNotFoundException;
import com.example.customerService.dtos.CustomerPdfDto;
import com.example.customerService.model.CustomerPdf;

@RestController
@RequestMapping("customer/pdf")
public class CustomerPdfController {

	@Autowired
	CustomerPdfService customerPdfService;
	
	@Autowired
	SavePdfService savePdfService;

	@PostMapping("/add")
	public ResponseEntity<String> addCustomerPdf(@ModelAttribute CustomerPdfDto customerPdfDto) {

		try {
			
			savePdfService.savePdf(customerPdfDto);
			return new ResponseEntity<String>("customer added successfully!!", HttpStatus.CREATED);

		} catch (Exception e) {
			// TODO: handle exception

			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/getPdf/{email}")
	public ResponseEntity<CustomerPdf> getCustomerPdfByCustomerEmail(@PathVariable String email) throws CustomerPdfNotFoundException{
		
		return new ResponseEntity<>(customerPdfService.getCustomerPdfByCustomerEmail(email),HttpStatus.FOUND);
	}

}
