package com.serviceproduct.product.repository;

import com.serviceproduct.product.entities.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Long> {

}
