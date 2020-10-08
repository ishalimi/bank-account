package com.bank.bankaccount.services;

import com.bank.bankaccount.models.Account;

import java.util.List;

public interface IAccountService {
    Account findAccountById(Long id);

    List<Account> getAccounts();

    Account createAccount();
}
