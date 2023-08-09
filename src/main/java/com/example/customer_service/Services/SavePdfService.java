package com.example.customer_service.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.example.customer_service.controller.CustomerForApprovementController;
import com.example.customer_service.customExceptions.S3FileSavingException;
import com.example.customer_service.dtos.CustomerForApprovemetnDto;


public interface SavePdfService {
	
	String savePdf(CustomerForApprovemetnDto customerForApprDto) throws IOException, S3FileSavingException;

}
