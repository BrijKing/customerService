package com.example.customer_service.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CombinedCustomerDTO {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String address;
    private List<CustomerPdfDTO> pdfs;
}
