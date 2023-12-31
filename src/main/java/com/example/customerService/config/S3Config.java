package com.example.customerService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	
	   @Value("${awsAccessKey}")
	    private String accessKey;

	    @Value("${awsSecretKey}")
	    private String secret;

	    @Value("${region}")
	    private String region;

	@Bean
	public AmazonS3 amazonS3() {
		
		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secret);
		 return AmazonS3ClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
	}

}
