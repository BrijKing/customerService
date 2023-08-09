package com.example.customer_service.customExceptions;

public class ConvertMultipartFileToFileException extends Exception {
	
	public ConvertMultipartFileToFileException() {
		super("There was an error while conveting file");
	}

}
