package com.nick.example.graphql_example_kickstart.repository;

import com.nick.example.graphql_example_kickstart.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);
}
