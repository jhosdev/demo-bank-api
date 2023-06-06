package com.jhosdev.demobankapi.controller;

import com.jhosdev.demobankapi.model.Transaction;
import com.jhosdev.demobankapi.repository.TransactionRepository;
import com.jhosdev.demobankapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bank/v1")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //URl: http://localhost:8080/api/bank/v1/transactions
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    //URl: http://localhost:8080/api/bank/v1/transactions/filterByNameCustomer
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/transactions/filterByNameCustomer")
    public ResponseEntity<List<Transaction>> getAllTransactionsByNameCustomer(@RequestParam("nameCustomer") String nameCustomer) {
        return new ResponseEntity<List<Transaction>>(transactionService.findAllByAccount_NameCustomer(nameCustomer), HttpStatus.OK);
    }

    //URl: http://localhost:8080/api/bank/v1/transactions/filterByCreateDateRange
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/transactions/filterByCreateDateRange")
    public ResponseEntity<List<Transaction>> getAllTransactionsByCreateDateRange(@RequestParam("startDate") LocalDateTime startDate,
                                                                                 @RequestParam("endDate") LocalDateTime endDate) {
        return new ResponseEntity<List<Transaction>>(transactionService.findAllByCreateDateBetween(startDate, endDate), HttpStatus.OK);
    }

}
