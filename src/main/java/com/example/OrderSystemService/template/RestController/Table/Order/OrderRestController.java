package com.example.OrderSystemService.template.RestController.Table.Order;

import com.example.OrderSystemService.Base.API.Response.CAPIResponse;
import com.example.OrderSystemService.Base.Class.CResponse;
import com.example.OrderSystemService.template.API.Request.Order.CCreateOrderRequest;
import com.example.OrderSystemService.template.API.Response.CustomerOrder.CGetCustomerOrder;
import com.example.OrderSystemService.template.API.Response.DTO.Mapper.CustomerOrderMapper;
import com.example.OrderSystemService.template.Model.Table.Order.Orders;
import com.example.OrderSystemService.template.Service.Table.Order.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    CAPIResponse createOrder(@Valid @RequestBody CCreateOrderRequest request) throws Exception {
        CAPIResponse apiResponse = new CAPIResponse();

        CResponse response = orderService.createOrder(request);

        if(response.isSuccess())
        {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setSuccessMessage(response.getMessage());
            return apiResponse;
        }

        apiResponse.setStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(response.getMessage());
        return apiResponse;
    }

    @PutMapping("/orders/{orderId}/status")
    CAPIResponse updateOrderStatus(@PathVariable Long orderId)throws Exception {
        CAPIResponse apiResponse = new CAPIResponse();

        CResponse response = orderService.updateOrderStatus(orderId);

        if(response.isSuccess())
        {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setSuccessMessage(response.getMessage());
            return apiResponse;
        }

        apiResponse.setStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(response.getMessage());
        return apiResponse;
    }

    @GetMapping ("/customers/{customerId}/order")
    CGetCustomerOrder getCustomerOrder(@PathVariable Long customerId)throws Exception {
        CGetCustomerOrder apiResponse = new CGetCustomerOrder();

        CResponse response = orderService.getCustomerOrder(customerId);

        if(response.isSuccess())
        {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setCustomerOrder(CustomerOrderMapper.parse((List<Orders>) response.getData()));
            apiResponse.setSuccessMessage(response.getMessage());
            return apiResponse;
        }

        apiResponse.setStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setErrorMessage(response.getMessage());
        return apiResponse;
    }

}
