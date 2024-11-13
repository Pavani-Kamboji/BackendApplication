package com.example.book_exchange.repository;

import com.example.book_exchange.model.Book_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface Book_tableRepository extends JpaRepository<Book_table, Long> {
    @Query(nativeQuery = true, value = "select * from book_table where name = :data or author=:data or title=:data or genre=:data ")
    Optional<Book_table> getGetbooksbyName(String data);
}
