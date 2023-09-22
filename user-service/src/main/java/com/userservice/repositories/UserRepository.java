package com.userservice.repositories;

import com.userservice.entities.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends ListCrudRepository<UserEntity, String> {
    @Query(value = "INSERT INTO users (username, password) " +
            "VALUES (:#{#username}, :#{#password}) ", nativeQuery = true)
    @Modifying
    void saveUser(@Param("username") String username, @Param("password") String password);
}
