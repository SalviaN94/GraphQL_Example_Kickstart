package com.nick.example.graphql_example_kickstart.repository;

import com.nick.example.graphql_example_kickstart.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findByName(String name);
}
