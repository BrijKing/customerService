package com.example.customerService.customExceptions;

public class ConvertMultipartFileToFileException extends Exception {
	
	public ConvertMultipartFileToFileException() {
		super("There was an error while conveting file");
	}

}
