package com.EnzoBonatoPersonal.MyLittleLibrary.controllers;

import com.EnzoBonatoPersonal.MyLittleLibrary.models.Book;
import com.EnzoBonatoPersonal.MyLittleLibrary.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;
import com.EnzoBonatoPersonal.MyLittleLibrary.exceptions.BookNotFoundException;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return bookRepository.findByTitleIgnoreCase(title)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new BookNotFoundException(title));
    }
}
