package com.serviceproduct.product.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private String description;
    private Long stock;
    private BigDecimal price;
    private String status;
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonBackReference //este es un dato que ira como subObjeto de otro y debe ir con esta anotacion para evitar el error de inversion infinita
    private CategoryEntity category;


    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", category=" + category +
                '}';
    }
}
