package com.example.book_exchange.controller;

import com.example.book_exchange.model.Transaction;
import com.example.book_exchange.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

        @Autowired
        TransactionService transactionService;

        @PostMapping
        public Transaction createTransaction(@RequestBody Transaction transaction)
        {
            return transactionService.saveTransaction(transaction);
        }

        @PostMapping("/{transactionId}")
        public Transaction updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction)
        {
            return transactionService.updateTransaction(transaction,transactionId);
        }

//        @GetMapping("/{transactionId}")
//        public List<Transaction> getAllTransactionsbymemberId()
//        {
//            return transactionService.getAllTransactions();
//        }

    }

