package com.example.book_exchange.repository;

import com.example.book_exchange.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(nativeQuery = true, value = "select * from txn_table where id = :id")
    Optional<Transaction> getAllTransactionsbymemberId(String id);
}

