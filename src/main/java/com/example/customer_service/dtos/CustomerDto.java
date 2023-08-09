package com.example.customer_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
	
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;
	
	private String address;


}
