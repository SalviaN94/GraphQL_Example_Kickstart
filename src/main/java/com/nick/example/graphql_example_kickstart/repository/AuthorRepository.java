package com.nick.example.graphql_example_kickstart.repository;

import com.nick.example.graphql_example_kickstart.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByFirstNameAndLastName(String firstName, String lastName);
    Author findAuthorById(Long id);
}
