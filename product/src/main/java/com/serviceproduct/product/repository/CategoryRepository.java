package com.serviceproduct.product.repository;

import com.serviceproduct.product.entities.CategoryEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<CategoryEntity, Long> {

}
