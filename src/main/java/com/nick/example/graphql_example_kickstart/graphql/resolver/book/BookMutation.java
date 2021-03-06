package com.nick.example.graphql_example_kickstart.graphql.resolver.book;

import com.nick.example.graphql_example_kickstart.entity.Book;
import com.nick.example.graphql_example_kickstart.graphql.classes.CreateBookInput;
import com.nick.example.graphql_example_kickstart.graphql.resolver.Mutation;
import com.nick.example.graphql_example_kickstart.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class BookMutation extends Mutation {

    @Autowired
    BookService bookService;

    @PreAuthorize("hasAuthority('WRITER') or hasAuthority('ADMIN')")
    public Book createBook(CreateBookInput input){
        return bookService.createBook(new Book(input.getName(), input.getPageCount()), input.getAuthorId());
    }

    @PreAuthorize("hasAuthority('WRITER') or hasAuthority('ADMIN')")
    public Book updateBook(Book input){
        return bookService.updateBook(input);
    }

    @PreAuthorize("hasAuthority('WRITER') or hasAuthority('ADMIN')")
    public Book deleteBook(Book book){
        return bookService.deleteBook(book.getId());
    }

}
