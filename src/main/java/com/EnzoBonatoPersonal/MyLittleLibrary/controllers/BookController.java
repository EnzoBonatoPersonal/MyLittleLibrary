package com.EnzoBonatoPersonal.MyLittleLibrary.controllers;

import com.EnzoBonatoPersonal.MyLittleLibrary.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("The Great Gatsby", "A story about the American Dream", "F. Scott Fitzgerald", 180));
        books.add(new Book("Le Petit Prince", "Conte philosophique", "Antoine de Saint-Exupéry", 96));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }
}