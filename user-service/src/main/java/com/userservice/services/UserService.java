package com.userservice.services;

import com.userservice.entities.UserEntity;
import com.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUserByUsername(String username){
        return userRepository.findById(username).orElse(null);
    }

    @Transactional
    public void saveNewUser(String username, String password){
        userRepository.saveUser(username, password);
    }
}
