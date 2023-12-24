// com.example.banking.repository.UserRepository

package com.example.banking.repository;

import com.example.banking.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Custom queries can be added here if needed
    boolean existsByUsernameAndPassword(String username, String password);
}
