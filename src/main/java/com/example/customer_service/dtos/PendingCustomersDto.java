package com.example.customer_service.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PendingCustomersDto {

    private String email;

    private boolean isSigned;

    private String signBy;


}
