package com.example.OrderSystemService.template.Service.Table.Customer;

import com.example.OrderSystemService.Base.Class.CResponse;
import com.example.OrderSystemService.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderSystemService.template.Model.Table.Customer.Customer;
import com.example.OrderSystemService.template.Repository.Table.Card.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CResponse createCustomer(CCreateCustomerRequest request){

        CResponse response = new CResponse();

        Customer customer = new Customer();

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());

        customerRepository.save(customer);

        return response;
    }

}