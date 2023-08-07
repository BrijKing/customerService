package com.example.customerService.dtos;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPdfDto {
	
	
	private String email;
	
	private boolean isSigned;
	
	private String signBy;
	
	private MultipartFile pdfData;

}
