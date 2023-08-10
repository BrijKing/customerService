package com.example.customer_service.services;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import com.example.customer_service.custom_exception.FileDownloadingException;
import com.example.customer_service.custom_exception.S3FileSavingException;

public interface S3FileService {

	Binary downloadFile(String bucketName, String filename) throws FileDownloadingException;

	String saveFile(MultipartFile file, String customerEmail, String bucketName) throws IOException, S3FileSavingException;

}