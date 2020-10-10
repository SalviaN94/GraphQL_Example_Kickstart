package com.nick.example.graphql_example_kickstart.graphql.resolver.book;

import com.nick.example.graphql_example_kickstart.entity.Book;
import com.nick.example.graphql_example_kickstart.graphql.resolver.Query;
import com.nick.example.graphql_example_kickstart.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQuery extends Query {

    @Autowired
    BookService bookService;

    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    public Book getBookById(Long id){
        return bookService.getBook(id).get();
    }
}
