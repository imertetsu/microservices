package com.userservice.repositories;

import com.userservice.dto.CustomerDTO;
import com.userservice.entities.CustomerEntity;
import com.userservice.entities.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity,Long> {

    @Query(value = "INSERT INTO customers (name, email, phone_number, address, username) " +
            "VALUES (:#{#customerDTO.name}, :#{#customerDTO.email}, :#{#customerDTO.phoneNumber}, :#{#customerDTO.address}, :#{#customerDTO.getUser().getUsername()}); ", nativeQuery = true)
    @Modifying
    void saveCustomer(@Param("customerDTO") CustomerDTO customerDTO);

    CustomerEntity findByPhoneNumber(String phoneNumber);
}
