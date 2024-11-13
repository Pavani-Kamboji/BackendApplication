package com.example.book_exchange.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="book_table")
@AllArgsConstructor
@NoArgsConstructor

public class Book_table    {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String publisher;

    private String genre;

    @Column(name = "book_condition")
    private String book_condition;

}
