package com.nick.example.graphql_example_kickstart;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nick.example.graphql_example_kickstart.entity.Author;
import com.nick.example.graphql_example_kickstart.entity.Book;
import com.nick.example.graphql_example_kickstart.entity.User;
import com.nick.example.graphql_example_kickstart.repository.AuthorRepository;
import com.nick.example.graphql_example_kickstart.repository.BookRepository;
import com.nick.example.graphql_example_kickstart.repository.UserRepository;
import com.nick.example.graphql_example_kickstart.service.UserService;
import graphql.Scalars;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String ...args) throws Exception{

        authorRepository.deleteAll();
        bookRepository.deleteAll();

        Author author = new Author("John", "Doe");
        authorRepository.save(author);

        bookRepository.save(new Book("Book of Dummy I", 100, author));
        bookRepository.save(new Book("Book of Dummy II", 200, author));
        bookRepository.save(new Book("Book of Dummy III", 100, author));

        userService.createUser(new User("Admin", "admin", "ADMIN"));
        userService.createUser(new User("John Doe", "IAMWRITER", "WRITER" ));
        userService.createUser(new User("Random Reader", "randomReader", "READER"));
    }
}