package com.example.book_exchange.controller;

import com.example.book_exchange.model.Book_table;
import com.example.book_exchange.service.Book_tableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book_table")
public class Book_tableController {

    @Autowired
    Book_tableService book_tableService;

    @PostMapping
    public Book_table createBook_table(@RequestBody Book_table book_table){
        return book_tableService.saveBook_table(book_table);
    }

    @PostMapping("/{book_tableId}")
    public Book_table updateBook_table(@PathVariable Long book_tableId, @RequestBody Book_table book_table){
        return book_tableService.updateBook_table(book_table,book_tableId);
    }

    @GetMapping("/{book_tableName}")
    public Book_table getGetbooksbyName(@PathVariable String book_tableName){
        return book_tableService.getGetbooksbyName(book_tableName);
    }

    @GetMapping
    public List<Book_table> getAllBook_table(){
        return book_tableService.getAllBooks();
    }

    @DeleteMapping("/{book_tableId}")
    public void deleteBook(@PathVariable Long book_tableId){
        book_tableService.deleteBook(book_tableId);
    }

    }

