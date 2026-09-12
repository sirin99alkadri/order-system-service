package com.example.OrderSystemService.template.API.Request.Order;

import com.example.OrderSystemService.Base.API.Request.CAPIRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CCreateOrderRequest extends CAPIRequest {

    @NotNull
    private Long customerId;

    @NotNull
    private Long quantity;

    @NotNull
    private Double price;

    @NotBlank
    private String productName;

}
