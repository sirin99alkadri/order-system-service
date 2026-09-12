package com.example.OrderSystemService.template.API.Response.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOrderDTO {

    private String productName;

    private Long quantity;

    private Double price;

    private String status;

    private String customerFullName;

    private String email;

    private String phone;
}
