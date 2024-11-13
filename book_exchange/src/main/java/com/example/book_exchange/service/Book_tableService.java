package com.example.book_exchange.service;

import com.example.book_exchange.model.Book_table;
import com.example.book_exchange.repository.Book_tableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class Book_tableService {

    @Autowired
    Book_tableRepository book_tableRepository;

    public List<Book_table> getAllBooks()
    {
        return book_tableRepository.findAll();
    }

    public Book_table getGetbooksbyName(String book_tableName)
    {
        return book_tableRepository.getGetbooksbyName(book_tableName).get();
    }

    public Book_table saveBook_table(Book_table book_table)
    {
        return book_tableRepository.save(book_table);
    }

    public Book_table updateBook_table(Book_table book_table, Long book_tableId)

    {
        Book_table updateBook = book_tableRepository.findById(book_tableId).get();
        updateBook.setTitle(book_table.getTitle());
        updateBook.setAuthor(book_table.getAuthor());
        updateBook.setPublisher(book_table.getPublisher());
        updateBook.setGenre(book_table.getGenre());
        updateBook.setBook_condition(book_table.getBook_condition());
        return book_tableRepository.save(updateBook);
    }

    public void deleteBook(Long book_tableId) {
        Book_table deletebook_table = book_tableRepository.findById(book_tableId).get();
        book_tableRepository.delete(deletebook_table);
    }


    }


