package com.jhosdev.demobankapi.service;

import com.jhosdev.demobankapi.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();

    boolean existsByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    boolean existsByAccount_NameCustomer(String nameCustomer);

    List<Transaction> findAllByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<Transaction> findAllByAccount_NameCustomer(String nameCustomer);
}
