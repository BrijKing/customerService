package com.example.customer_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerForApprovement {
	
	
	@Id
	private String id;

	@Indexed(unique = true)
	private String email;
	
	private boolean isSigned;
	
	private String signBy;
	
	private byte[] pdfData;

}
