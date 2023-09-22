package com.userservice.services;

import com.userservice.dto.CustomerDTO;
import com.userservice.entities.CustomerEntity;
import com.userservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerEntity> getAllCustomers(){
        return customerRepository.findAll();
    }

    public CustomerEntity getCustomerById(Long customerId){
        return customerRepository.findById(customerId).orElse(null);
    }

    @Transactional //este y el @Modifying estan estrechamente relacionados
    public void saveCustomer(CustomerDTO customerDTO){
        customerRepository.saveCustomer(customerDTO);
    }

    public CustomerEntity getCustomerByPhoneNumber(String phoneNumber){
        return customerRepository.findByPhoneNumber(phoneNumber);
    }
}
