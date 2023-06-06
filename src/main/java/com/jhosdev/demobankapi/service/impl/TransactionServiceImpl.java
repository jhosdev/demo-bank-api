package com.jhosdev.demobankapi.service.impl;

import com.jhosdev.demobankapi.model.Transaction;
import com.jhosdev.demobankapi.repository.TransactionRepository;
import com.jhosdev.demobankapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public boolean existsByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.existsByCreateDateBetween(startDate, endDate);
    }

    @Override
    public boolean existsByAccount_NameCustomer(String nameCustomer) {
        return transactionRepository.existsByAccount_NameCustomer(nameCustomer);
    }

    @Override
    public List<Transaction> findAllByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findAllByCreateDateBetween(startDate, endDate);
    }

    @Override
    public List<Transaction> findAllByAccount_NameCustomer(String nameCustomer) {
        return transactionRepository.findAllByAccount_NameCustomer(nameCustomer);
    }
}
