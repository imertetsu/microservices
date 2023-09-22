package com.userservice.controllers;

import com.userservice.dto.CustomerDTO;
import com.userservice.dto.CustomerResponseDTO;
import com.userservice.entities.CustomerEntity;
import com.userservice.entities.UserEntity;
import com.userservice.services.CustomerService;
import com.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder, UserService userService) {
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        List<CustomerEntity> customerEntityList = this.customerService.getAllCustomers();
        List<CustomerResponseDTO> customerResponseDTOList = customerEntityList.stream().map(
                customer -> {
                    CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
                    customerResponseDTO.setId(customer.getCustomerId());
                    customerResponseDTO.setName(customer.getName());
                    customerResponseDTO.setEmail(customer.getEmail());
                    customerResponseDTO.setAddress(customer.getAddress());
                    customerResponseDTO.setPhoneNumber(customer.getPhoneNumber());
                    customerResponseDTO.setUsername(customer.getUser().getUsername());
                    return customerResponseDTO;
                }
        ).collect(Collectors.toList());

        return ResponseEntity.ok(customerResponseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable(name = "id")Long customerId){

        CustomerEntity customerEntity = this.customerService.getCustomerById(customerId);
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setId(customerEntity.getCustomerId());
        customerResponseDTO.setName(customerEntity.getName());
        customerResponseDTO.setEmail(customerEntity.getEmail());
        customerResponseDTO.setAddress(customerEntity.getAddress());
        customerResponseDTO.setPhoneNumber(customerEntity.getPhoneNumber());
        customerResponseDTO.setUsername(customerEntity.getUser().getUsername());
        return ResponseEntity.ok(customerResponseDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> saveNewCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerEntity customerEntity = this.customerService.getCustomerByPhoneNumber(customerDTO.getPhoneNumber());
        if (customerEntity != null){
            return ResponseEntity.badRequest().build();
        }
        String username = customerDTO.getUser().getUsername();
        String password = passwordEncoder.encode(customerDTO.getUser().getPassword());
        UserEntity newUser = new UserEntity(username, password);
        String customerName = customerDTO.getName();
        String customerAddress = customerDTO.getAddress();
        String customerPhone = customerDTO.getPhoneNumber();
        String customerEmail = customerDTO.getEmail();
        CustomerDTO newCustomer = new CustomerDTO(customerName, customerEmail, customerPhone, customerAddress, newUser);

        this.userService.saveNewUser(username, password);
        this.customerService.saveCustomer(newCustomer);
        return ResponseEntity.noContent().build();
    }
}
