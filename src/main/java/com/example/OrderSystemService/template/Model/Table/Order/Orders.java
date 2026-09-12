package com.example.OrderSystemService.template.Model.Table.Order;

import com.example.OrderSystemService.template.Enum.EOrderStatus;
import com.example.OrderSystemService.template.Model.Table.Customer.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "ORDERS")
@Entity
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@ToString
public class Orders {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private EOrderStatus status;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}
