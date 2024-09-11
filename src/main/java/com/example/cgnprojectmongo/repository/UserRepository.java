package com.example.cgnprojectmongo.repository;

import com.example.cgnprojectmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findById(Integer id);

}
