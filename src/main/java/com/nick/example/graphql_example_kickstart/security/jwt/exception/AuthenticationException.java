package com.nick.example.graphql_example_kickstart.security.jwt.exception;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException(String message, Throwable cause){
        super(message, cause);
    }
}
