package com.nick.example.graphql_example_kickstart.repository;

import com.nick.example.graphql_example_kickstart.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
