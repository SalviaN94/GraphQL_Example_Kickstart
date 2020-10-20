package com.nick.example.graphql_example_kickstart.graphql.resolver.author;

import com.nick.example.graphql_example_kickstart.entity.Author;
import com.nick.example.graphql_example_kickstart.graphql.resolver.Mutation;
import com.nick.example.graphql_example_kickstart.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation extends Mutation {

    @Autowired
    AuthorService authorService;

    @PreAuthorize("hasAuthority('WRITER') or hasAuthority('ADMIN')")
    public Author createAuthor(Author input){
        return authorService.createAuthor(input);
    }
}
