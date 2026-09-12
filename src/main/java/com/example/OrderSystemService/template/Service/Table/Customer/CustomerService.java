package com.example.OrderSystemService.template.Service.Table.Customer;

import com.example.OrderSystemService.Base.Class.CResponse;
import com.example.OrderSystemService.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderSystemService.template.Model.Table.Customer.Customer;
import com.example.OrderSystemService.template.Repository.Table.Customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CResponse createCustomer(CCreateCustomerRequest request){

        log.info("create customer");

        CResponse response = new CResponse();

        Customer customer = new Customer();

        if (customerRepository.existsByEmail(request.getEmail())) {

            log.error("Email already exists");
            response.setSuccess(false);
            response.setMessage("Email already exists");

            return response;
        }

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());

        customerRepository.save(customer);

        return response;
    }

    public CResponse findCustomerById(Long id)
    {
        CResponse response = new CResponse();

        Optional<?> op = customerRepository.findById(id);

        if(op.isEmpty())
        {
            response.setMessage("customer not found with id: " + id);
            return response;
        }

        Customer customer = (Customer) op.get();

        response.setData(customer);

        return response;
    }

}