package com.example.OrderSystemService.template.API.Request.Customer;

import com.example.OrderSystemService.Base.API.Request.CAPIRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CCreateCustomerRequest extends CAPIRequest {

    @NotBlank
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

}
