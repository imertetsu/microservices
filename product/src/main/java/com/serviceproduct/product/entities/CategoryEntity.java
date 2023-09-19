package com.serviceproduct.product.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
//la que contiene los items o los datos de otra entidad debe ir con esta anotacion para evitar el error de inversion infinita

    private List<ProductEntity> products;
}
