package com.nick.example.graphql_example_kickstart.graphql.resolver.user;

import com.nick.example.graphql_example_kickstart.entity.User;
import com.nick.example.graphql_example_kickstart.graphql.resolver.Mutation;
import com.nick.example.graphql_example_kickstart.repository.UserRepository;
import com.nick.example.graphql_example_kickstart.security.jwt.JwtAuthenticationService;
import com.nick.example.graphql_example_kickstart.security.jwt.exception.AuthenticationException;
import com.nick.example.graphql_example_kickstart.service.UserService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class UserMutation extends Mutation {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtAuthenticationService authenticationService;

    @PreAuthorize("hasAuthority('ADMIN')")
    public User createUser(User input, DataFetchingEnvironment environment){
        User createdUser = userService.createUser(input);
        if(createdUser == null){

        }
        return createdUser;
    }

    public String loginUser(User input, DataFetchingEnvironment environment) throws Exception {
        String token;
        try {
            token = authenticationService.createAuthenticationToken(input.getUsername(), input.getPassword());
        }catch (AuthenticationException e){
            e.getMessage();
            throw new Exception("Exception");
        }
        return token;
    }
}