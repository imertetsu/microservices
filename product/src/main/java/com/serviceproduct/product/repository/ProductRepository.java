package com.serviceproduct.product.repository;

import com.serviceproduct.product.entities.CategoryEntity;
import com.serviceproduct.product.entities.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByCategoryId(Long categoryId);
}
