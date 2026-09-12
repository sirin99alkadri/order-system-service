package com.example.OrderSystemService;

import com.example.OrderSystemService.Base.Class.CResponse;
import com.example.OrderSystemService.template.API.Request.Customer.CCreateCustomerRequest;
import com.example.OrderSystemService.template.Model.Table.Customer.Customer;
import com.example.OrderSystemService.template.Repository.Table.Customer.CustomerRepository;
import com.example.OrderSystemService.template.Service.Table.Customer.CustomerService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void createCustomer_shouldReturnError_whenEmailAlreadyExists() {

        // Arrange
        CCreateCustomerRequest request = new CCreateCustomerRequest();

        request.setFullName("Ahmad Ali");
        request.setEmail("moalkadri@gmail.com");
        request.setPhone("0999999999");

        when(customerRepository.existsByEmail("ahmad@test.com"))
                .thenReturn(true);

        // Act
        CResponse response =
                customerService.createCustomer(request);

        // Assert
        assertFalse(response.isSuccess());
        assertEquals("Email already exists", response.getMessage());

        verify(customerRepository, never())
                .save(any(Customer.class));
    }
}