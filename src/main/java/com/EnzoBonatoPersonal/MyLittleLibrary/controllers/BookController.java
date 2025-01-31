package com.EnzoBonatoPersonal.MyLittleLibrary.controllers;

import com.EnzoBonatoPersonal.MyLittleLibrary.models.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book("Le Petit Prince", "Conte philosophique", "Antoine de Saint-Exupéry", 96, false));
        books.add(new Book("1984", "Dystopie sur un régime totalitaire", "George Orwell", 328, false));
        books.add(new Book("Harry Potter à l'école des sorciers", "L’histoire d’un jeune sorcier découvrant son destin", "J.K. Rowling", 309, false));
        books.add(new Book("L'Alchimiste", "Un voyage initiatique et spirituel", "Paulo Coelho", 208, false));
        books.add(new Book("Les Misérables", "Une fresque sociale et historique de la France du XIXe siècle", "Victor Hugo", 1463, false));
        books.add(new Book("Don Quichotte", "Les aventures d’un chevalier rêvant de justice", "Miguel de Cervantes", 863, false));
        books.add(new Book("Fahrenheit 451", "Un futur où les livres sont interdits", "Ray Bradbury", 249, false));
        books.add(new Book("Moby Dick", "La quête obsessionnelle d’un capitaine contre une baleine blanche", "Herman Melville", 635, false));
        books.add(new Book("Pride and Prejudice", "Une histoire d'amour et de société", "Jane Austen", 432, false));
        books.add(new Book("Le Comte de Monte-Cristo", "Une vengeance épique d’un homme accusé à tort", "Alexandre Dumas", 1312, false));
        books.add(new Book("Crime et Châtiment", "Un drame psychologique sur la culpabilité", "Fiodor Dostoïevski", 671, false));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        return books.stream()
            .filter(book -> book.getTitle().equalsIgnoreCase(title))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}