package com.jhosdev.demobankapi.service;

import com.jhosdev.demobankapi.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAllAccounts();

    Account getAccountById(Long id);
}
