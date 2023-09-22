package com.userservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, unique = true)
    private Long customerId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, unique = true, length = 100)
    @Email
    private String email;
    @Column(nullable = false, unique = true, length = 10)
    private String phoneNumber;
    @Column(length = 200)
    private String address;

    @OneToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    @JsonManagedReference
    private UserEntity user;
}
