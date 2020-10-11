package com.nick.example.graphql_example_kickstart.repository;

import com.nick.example.graphql_example_kickstart.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    Author findByFirstNameAndLastName(String firstName, String lastName);
    Author findAuthorById(String id);
}
