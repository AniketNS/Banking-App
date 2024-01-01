package com.example.banking.service;

import com.example.banking.model.User;
import com.example.banking.repository.MemberRepository;
import com.example.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public UserService(UserRepository userRepository, MemberRepository memberRepository){
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
    }

    public boolean isUserRegistered(String username, String password){
        // Check if a user with the given username and password exists
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    public List<User> getAllMembers() {
        return userRepository.findAll();
    }
}
