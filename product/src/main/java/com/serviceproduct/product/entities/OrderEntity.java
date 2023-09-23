package com.serviceproduct.product.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true)
    private Long orderId;
    @Column(name = "customer_id", nullable = false, unique = true)
    private Long customerId;
    @Column(name = "order_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime orderDate;
    @Column(name = "total_price", columnDefinition = "Decimal(6,2)")
    private BigDecimal totalPrice;
    @Column(name = "payment_method", nullable = false, length = 1)
    private String paymentMethod;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @JsonManagedReference
    @OrderBy("price DESC")
    private List<OrderProductEntity> orderProductList;


}
