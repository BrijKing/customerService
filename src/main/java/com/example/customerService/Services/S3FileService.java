package com.example.customerService.Services;

import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import com.example.customerService.customExceptions.FileDownloadingException;
import com.example.customerService.customExceptions.S3FileSavingException;

public interface S3FileService {

	Binary downloadFile(String bucketName, String filename) throws FileDownloadingException;

	String saveFile(MultipartFile file, String customerEmail, String bucketName) throws IOException, S3FileSavingException;

}
