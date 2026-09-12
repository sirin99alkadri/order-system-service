package com.example.OrderSystemService.template.RestController.Table.Customer;

import com.example.OrderSystemService.Base.API.Response.CAPIResponse;
import com.example.OrderSystemService.Base.Class.CResponse;
import com.example.OrderSystemService.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderSystemService.template.Service.Table.Customer.CustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/internal")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customers")
    CAPIResponse createCustomer(@Valid @RequestBody CCreateCustomerRequest request) throws Exception {

        log.info("Incoming request: POST /internal/customers");

        CAPIResponse apiResponse = new CAPIResponse();

        CResponse response = customerService.createCustomer(request);

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

}
