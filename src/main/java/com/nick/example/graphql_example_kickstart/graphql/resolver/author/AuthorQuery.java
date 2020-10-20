package com.nick.example.graphql_example_kickstart.graphql.resolver.author;

import com.nick.example.graphql_example_kickstart.entity.Author;
import com.nick.example.graphql_example_kickstart.graphql.resolver.Query;
import com.nick.example.graphql_example_kickstart.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class AuthorQuery extends Query {

    @Autowired
    AuthorService authorService;

    @PreAuthorize("hasAuthority('WRITER') or hasAuthority('ADMIN') or hasAuthority('READER')")
    public Author getAuthor(String id){
        return authorService.getAuthor(id).get();
    }
}
