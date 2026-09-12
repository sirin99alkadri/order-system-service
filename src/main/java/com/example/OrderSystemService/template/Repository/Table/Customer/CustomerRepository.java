package com.example.OrderSystemService.template.Repository.Table.Customer;

import com.example.OrderSystemService.template.Model.Table.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
