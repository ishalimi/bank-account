package com.bank.bankaccount.services;

import com.bank.bankaccount.models.Account;
import com.bank.bankaccount.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.getAccounts();
    }

    @Override
    public Account createAccount() {
        return accountRepository.createAccount();
    }
}
