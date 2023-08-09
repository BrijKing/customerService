package com.example.customer_service.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.customer_service.custom_exception.S3FileSavingException;
import com.example.customer_service.dtos.CustomerForApprovemetnDto;
import com.example.customer_service.model.CustomerPdf;
import com.example.customer_service.services.CustomerPdfService;
import com.example.customer_service.services.S3FileService;
import com.example.customer_service.services.SavePdfService;


@Service
public class SavePdfServiceImp implements SavePdfService {

	@Autowired
	CustomerPdfService customerPdfService;

	@Autowired
	S3FileService s3FileService;

	@Value("${bucketName}")
	private String bucketName;
	
	
	@Value("${saveIn}")
	private String saveIn;

	@Override
	public String savePdf(CustomerForApprovemetnDto customerForApprovemetnDto) throws IOException, S3FileSavingException {
		
		
		if (saveIn.equals("mongodb")) {
			


			CustomerPdf customerPdf = CustomerPdf.builder().email(customerForApprovemetnDto.getEmail())
					.isSigned(customerForApprovemetnDto.isSigned()).signBy(customerForApprovemetnDto.getSignBy())
					.pdfData(customerForApprovemetnDto.getPdfData().getBytes()).build();

			customerPdfService.addCustomerPdf(customerPdf);

		}

		else if (saveIn.equals("s3")) {

			s3FileService.saveFile(customerForApprovemetnDto.getPdfData(), customerForApprovemetnDto.getEmail(), bucketName);

		}
		return "customer save with pdf in " + saveIn  ;
	}

}
