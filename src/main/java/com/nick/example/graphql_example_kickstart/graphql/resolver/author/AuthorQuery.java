package com.nick.example.graphql_example_kickstart.graphql.resolver.author;

import com.nick.example.graphql_example_kickstart.entity.Author;
import com.nick.example.graphql_example_kickstart.graphql.resolver.Query;
import com.nick.example.graphql_example_kickstart.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorQuery extends Query {

    @Autowired
    AuthorService authorService;

    public Author getAuthor(String id){
        return authorService.getAuthor(id).get();
    }
}
