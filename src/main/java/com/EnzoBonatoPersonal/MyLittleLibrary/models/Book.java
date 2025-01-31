package com.EnzoBonatoPersonal.MyLittleLibrary.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String author;
    private int pages;
    private boolean available;
    private String genre;
}
