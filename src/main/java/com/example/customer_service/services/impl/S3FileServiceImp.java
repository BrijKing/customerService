package com.example.customer_service.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.customer_service.custom_exception.ConvertMultipartFileToFileException;
import com.example.customer_service.custom_exception.FileDownloadingException;
import com.example.customer_service.custom_exception.S3FileSavingException;
import com.example.customer_service.services.S3FileService;


@Service
public class S3FileServiceImp implements S3FileService {

	private final AmazonS3 s3;

	public S3FileServiceImp(AmazonS3 s3) {

		this.s3 = s3;
	}

	@Override
	public Binary downloadFile(String bucketName, String filename) throws FileDownloadingException {
		S3Object object = s3.getObject(bucketName, filename);
		S3ObjectInputStream objectContent = object.getObjectContent();
		
		try {
			return new Binary(objectContent.readAllBytes());
		} catch (Exception e) {

			throw new FileDownloadingException();
			
		}
	}

	@Override
	public String saveFile(MultipartFile file, String customerEmail, String bucketName) throws IOException, S3FileSavingException {

		String filename = customerEmail;

		while (true) {
			try {
				File file1 = convertMultiPartToFile(file);
				s3.putObject(bucketName, filename, file1);
				return "File Uploaded successfully!!";
			} catch (Exception e) {
	
				 throw new S3FileSavingException();
			}
		}

	}

	private File convertMultiPartToFile(MultipartFile file) throws ConvertMultipartFileToFileException {
	    try {
	        File convFile = new File(file.getOriginalFilename());
	        
	        try (FileOutputStream fos = new FileOutputStream(convFile)) {
	            fos.write(file.getBytes());
	        }
	        
	        return convFile;
	    } catch (Exception e) {
	        throw new ConvertMultipartFileToFileException();
	    }
	}

}
