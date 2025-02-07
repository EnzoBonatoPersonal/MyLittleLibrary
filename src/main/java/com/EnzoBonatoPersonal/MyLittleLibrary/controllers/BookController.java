package com.EnzoBonatoPersonal.MyLittleLibrary.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

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

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }


    @PutMapping("/edit/{id}")
    @Transactional
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Book book) {
        return bookRepository.findById(id)
            .map(existingBook -> {
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthor(book.getAuthor());
                existingBook.setGenre(book.getGenre());
                existingBook.setDescription(book.getDescription());
                existingBook.setPages(book.getPages());
                existingBook.setAvailable(book.isAvailable());
                return ResponseEntity.ok(existingBook);
            })
            .orElseThrow(() -> new BookNotFoundException(id.toString()));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException(id.toString()));
        bookRepository.delete(book);
        return ResponseEntity.noContent().build();
    }
}
