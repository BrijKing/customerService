package com.example.customerService.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import com.example.customerService.controller.CustomerForApprovementController;
import com.example.customerService.customExceptions.S3FileSavingException;
import com.example.customerService.dtos.CustomerForApprovemetnDto;


public interface SavePdfService {
	
	String savePdf(CustomerForApprovemetnDto customerForApprDto) throws IOException, S3FileSavingException;

}
