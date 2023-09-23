package com.serviceproduct.product.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "order_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductEntity {

    @Id
    @Column(name = "order_product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductId;
    @Id
    @Column(name = "order_id", nullable = false)
    private Long orderId;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    private Long quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonBackReference
    private OrderEntity order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private ProductEntity product;
}
