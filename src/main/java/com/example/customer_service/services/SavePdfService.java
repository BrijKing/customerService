package com.example.customer_service.services;

import java.io.IOException;

import com.example.customer_service.custom_exception.S3FileSavingException;
import com.example.customer_service.dtos.CustomerForApprovemetnDto;


public interface SavePdfService {
	
	String savePdf(CustomerForApprovemetnDto customerForApprDto) throws IOException, S3FileSavingException;

}
