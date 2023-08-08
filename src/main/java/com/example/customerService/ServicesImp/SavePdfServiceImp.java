package com.example.customerService.ServicesImp;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.customerService.Services.CustomerPdfService;
import com.example.customerService.Services.S3FileService;
import com.example.customerService.Services.SavePdfService;
import com.example.customerService.customExceptions.S3FileSavingException;
import com.example.customerService.dtos.CustomerPdfDto;
import com.example.customerService.model.CustomerPdf;


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
	public String savePdf(CustomerPdfDto customerPdfDto) throws IOException, S3FileSavingException {
		
		
		if (saveIn.equals("mongodb")) {
			
//			System.out.println("mongodb");

			CustomerPdf customerPdf = CustomerPdf.builder().email(customerPdfDto.getEmail())
					.isSigned(customerPdfDto.isSigned()).signBy(customerPdfDto.getSignBy())
					.pdfData(customerPdfDto.getPdfData().getBytes()).build();

			customerPdfService.addCustomerPdf(customerPdf);

		}

		else if (saveIn.equals("s3")) {

			s3FileService.saveFile(customerPdfDto.getPdfData(), customerPdfDto.getEmail(), bucketName);

		}
		return "customer save with pdf in " + saveIn  ;
	}

}
