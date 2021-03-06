package com.nick.example.graphql_example_kickstart.service;

import com.nick.example.graphql_example_kickstart.entity.Author;
import com.nick.example.graphql_example_kickstart.entity.Book;
import com.nick.example.graphql_example_kickstart.repository.AuthorRepository;
import com.nick.example.graphql_example_kickstart.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Book createBook(Book book, String authorId){
        Book existingBook = bookRepository.findByName(book.getName());
        if(existingBook != null) {
            return existingBook;
        }
        Author author = authorRepository.findAuthorById(authorId);
        if(author == null)
            return null;
        book.setAuthor(author);
        bookRepository.save(book);
        author.addBooks(book);
        authorRepository.save(author);
        return book;
    }

    @Transactional
    public Book updateBook(Book book){
        this.bookRepository.save(book);
        return book;
    }

    @Transactional
    public Book deleteBook(String id){
        Book book = this.bookRepository.findById(id).get();
        this.bookRepository.deleteById(id);
        return book;
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks(){
        return new ArrayList<>(this.bookRepository.findAll());
    }

    @Transactional(readOnly = true)
    public Optional<Book> getBook(String id){
        return this.bookRepository.findById(id);
    }

}
