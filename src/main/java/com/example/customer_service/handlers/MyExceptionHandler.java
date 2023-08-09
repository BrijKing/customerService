package com.example.customer_service.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.customer_service.customExceptions.ConvertMultipartFileToFileException;
import com.example.customer_service.customExceptions.CustomerPdfNotFoundException;
import com.example.customer_service.customExceptions.FileDownloadingException;
import com.example.customer_service.customExceptions.S3FileSavingException;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(CustomerPdfNotFoundException.class)
    public ResponseEntity<?> handleCustomerPdfNotFoundException(CustomerPdfNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileDownloadingException.class)
    public ResponseEntity<?> handleFileDownloadingException(FileDownloadingException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConvertMultipartFileToFileException.class)
    public ResponseEntity<?> handleConvertMultipartFileToFileException(ConvertMultipartFileToFileException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(S3FileSavingException.class)
    public ResponseEntity<?> handleS3FileSavingException(S3FileSavingException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
