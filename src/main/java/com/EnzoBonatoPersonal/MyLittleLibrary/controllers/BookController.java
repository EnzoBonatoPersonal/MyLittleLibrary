package com.EnzoBonatoPersonal.MyLittleLibrary.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.EnzoBonatoPersonal.MyLittleLibrary.models.Book;
import com.EnzoBonatoPersonal.MyLittleLibrary.repositories.BookRepository;
import com.EnzoBonatoPersonal.MyLittleLibrary.exceptions.BookNotFoundException;
import com.EnzoBonatoPersonal.MyLittleLibrary.exceptions.GenreNotFoundException;

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

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable String genre) {
        List<Book> books = bookRepository.findByGenreIgnoreCase(genre);
        if (books.isEmpty()) {
            throw new GenreNotFoundException(genre);
        }
        return ResponseEntity.ok(books);
    }
}
