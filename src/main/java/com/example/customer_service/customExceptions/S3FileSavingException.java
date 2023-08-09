package com.example.customer_service.customExceptions;

public class S3FileSavingException extends Exception {
	
	public S3FileSavingException() {
		
		super("There was an error while saving Pdf to S3 bucket");
	}

}
