package com.bank.bankaccount.repositories;

import com.bank.bankaccount.models.Account;

import java.util.List;

public interface IAccountRepository {
    Account findAccountById(Long id);

    List<Account> getAccounts();
}
