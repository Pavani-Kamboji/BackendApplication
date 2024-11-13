package com.example.book_exchange.service;
import org.springframework.stereotype.Service;
import com.example.book_exchange.model.Transaction;
import com.example.book_exchange.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Transaction transaction, Long transactionId) {
        Transaction update = transactionRepository.findById(transactionId).get();
        update.setId(transaction.getId());
        update.setCurrent_owner(transaction.getCurrent_owner());
        update.setBook_id(transaction.getBook_id());
        update.setRequester(transaction.getRequester());
        update.setDelivery_method(transaction.getDelivery_method());
        update.setStatus(transaction.getStatus());
        return transactionRepository.save(update);
    }


    
    
}

