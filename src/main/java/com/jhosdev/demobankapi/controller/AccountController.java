package com.jhosdev.demobankapi.controller;

import com.jhosdev.demobankapi.model.Account;
import com.jhosdev.demobankapi.model.Transaction;
import com.jhosdev.demobankapi.service.AccountService;
import com.jhosdev.demobankapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank/v1")
public class AccountController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    @Autowired
    public AccountController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    //URl: http://localhost:8080/api/bank/v1/accounts
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    //URl: http://localhost:8080/api/bank/v1/accounts
    //Method: POST
    @Transactional
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(Account account) {
        return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    //URl: http://localhost:8080/api/bank/v1/accounts/1/transactions
    //Method: POST
    @Transactional
    @GetMapping("/accounts/{id}/transactions")
    public ResponseEntity<List<Transaction>> createTransaction(@PathVariable(value = "id") Long accountId, @RequestBody Transaction transaction) {
        var nameCustomer = accountService.getAccountById(accountId).getNameCustomer();
        return new ResponseEntity<List<Transaction>>(transactionService.findAllByAccount_NameCustomer(nameCustomer), HttpStatus.OK);
    }

}
