package com.example.customerService.dtos;

import lombok.Data;

@Data
public class CustomerPdfDTO {
	private String email;
    private boolean isSigned;
    private String signBy;
    private byte[] pdfData; 
}
