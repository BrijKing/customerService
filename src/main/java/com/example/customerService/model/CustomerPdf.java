package com.example.customerService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerPdf {
	
	
	@Id
	private String id;
	
	private String email;
	
	private boolean isSigned;
	
	private String signBy;
	
	private byte[] pdfData;

}
