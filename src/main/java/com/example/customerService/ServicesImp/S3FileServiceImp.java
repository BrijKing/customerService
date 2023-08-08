package com.example.customerService.ServicesImp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.customerService.Services.S3FileService;
import com.example.customerService.customExceptions.ConvertMultipartFileToFileException;
import com.example.customerService.customExceptions.FileDownloadingException;
import com.example.customerService.customExceptions.S3FileSavingException;


@Service
public class S3FileServiceImp implements S3FileService {

	private final AmazonS3 s3;

	public S3FileServiceImp(AmazonS3 s3) {
		// TODO Auto-generated constructor stub
		this.s3 = s3;
	}

	@Override
	public Binary downloadFile(String bucketName, String filename) throws FileDownloadingException {
		S3Object object = s3.getObject(bucketName, filename);
		S3ObjectInputStream objectContent = object.getObjectContent();
		
		try {
			return new Binary(objectContent.readAllBytes());
		} catch (Exception e) {
			// TODO: handle exception
			throw new FileDownloadingException();
			
		}
	}

	@Override
	public String saveFile(MultipartFile file, String customerEmail, String bucketName) throws IOException, S3FileSavingException {

		String filename = customerEmail;

		while (true) {
			try {
				File file1 = convertMultiPartToFile(file);
				PutObjectResult putObjectResult = s3.putObject(bucketName, filename, file1);
				return "File Uploaded successfully!!";
			} catch (Exception e) {
	
				 throw new S3FileSavingException();
			}
		}

	}

	private File convertMultiPartToFile(MultipartFile file) throws ConvertMultipartFileToFileException {
		
		try {
			
			File convFile = new File(file.getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
			return convFile;
			
		}catch (Exception e) {
			// TODO: handle exception
			throw new ConvertMultipartFileToFileException();
		}

	
	}

}
