package com.example.OrderSystemService.template.Repository.Table.Order;

import com.example.OrderSystemService.template.Model.Table.Order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> getOrdersByCustomer_Id(Long customerId);
}
