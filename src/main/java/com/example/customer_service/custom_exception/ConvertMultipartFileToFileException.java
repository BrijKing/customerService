package com.example.customer_service.custom_exception;

public class ConvertMultipartFileToFileException extends Exception {
	
	public ConvertMultipartFileToFileException() {
		super("There was an error while conveting file");
	}

}
