package com.example.OrderSystemService.template.API.Response.CustomerOrder;

import com.example.OrderSystemService.Base.API.Response.CAPIResponse;
import com.example.OrderSystemService.template.API.Response.DTO.CustomerOrderDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CGetCustomerOrder extends CAPIResponse {

    private List<CustomerOrderDTO> customerOrder;
}
