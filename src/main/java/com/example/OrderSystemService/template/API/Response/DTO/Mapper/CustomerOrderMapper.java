package com.example.OrderSystemService.template.API.Response.DTO.Mapper;


import com.example.OrderSystemService.template.API.Response.DTO.CustomerOrderDTO;
import com.example.OrderSystemService.template.Model.Table.Order.Orders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CustomerOrderMapper {

    public static CustomerOrderDTO parse(Orders order)
    {
        if(order == null) return null;

        CustomerOrderDTO customerOrderDTO = new CustomerOrderDTO();

        customerOrderDTO.setCustomerFullName(order.getCustomer().getFullName());
        customerOrderDTO.setStatus(order.getStatus().name());
        customerOrderDTO.setPrice(order.getPrice());
        customerOrderDTO.setQuantity(order.getQuantity());
        customerOrderDTO.setEmail(order.getCustomer().getEmail());
        customerOrderDTO.setPhone(order.getCustomer().getPhone());
        customerOrderDTO.setProductName(order.getProductName());

        return customerOrderDTO;
    }

    public static List<CustomerOrderDTO> parse(List<Orders> orders){
        return orders.stream()
                .map(CustomerOrderMapper::parse)
                .collect(Collectors.toList());
    }
}
