package com.example.OrderSystemService.template.Service.Table.Order;

import com.example.OrderSystemService.Base.Class.CResponse;
import com.example.OrderSystemService.template.API.Request.Order.CCreateOrderRequest;
import com.example.OrderSystemService.template.Enum.EOrderStatus;
import com.example.OrderSystemService.template.Exception.OrderNotFoundException;
import com.example.OrderSystemService.template.Model.Table.Customer.Customer;
import com.example.OrderSystemService.template.Model.Table.Order.Orders;
import com.example.OrderSystemService.template.Repository.Table.Order.OrderRepository;
import com.example.OrderSystemService.template.Service.Table.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

    public CResponse createOrder(CCreateOrderRequest request){

        CResponse response = customerService.findCustomerById(request.getCustomerId());
        if(!response.isSuccess()) return response;

        Customer customer = (Customer) response.getData();

        Orders order = new Orders();

        order.setCustomer(customer);
        order.setPrice(request.getPrice());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setStatus(EOrderStatus.PENDING);

        orderRepository.save(order);

        return response;
    }

    public CResponse updateOrderStatus(Long orderId) {

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(
                        "Order not found with id: " + orderId
                ));

        order.setStatus(EOrderStatus.COMPLETED);

        Orders updatedOrder = orderRepository.save(order);

        CResponse response = new CResponse();
        response.setData(updatedOrder);

        return response;
    }

    public CResponse getCustomerOrder(Long customerId) {

        CResponse response = customerService.findCustomerById(customerId);
        if(!response.isSuccess()) return response;

        List<Orders> orders = orderRepository.getOrdersByCustomer_Id(customerId);

        if(orders.isEmpty())
        {
            response.setSuccess(false);
            response.setMessage("not found customer orders");
            return response;
        }

        response.setData(orders);

        return response;
    }
}