package com.example.banking.repository;

import com.example.banking.model.Members;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberRepository extends MongoRepository<Members, String> {


    List<Members> findAll();

    List<Members> findByType(String type);
}
