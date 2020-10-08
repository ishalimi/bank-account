package com.bank.bankaccount.controllers;

import com.bank.bankaccount.models.*;
import com.bank.bankaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {
    @Autowired
    IAccountService accountService;

    @PostMapping("/accounts/deposit/{id}")
    public ResponseEntity<AccountOperation> moneyDeposit(@PathVariable("id") Long id, @RequestBody Map<String, String> data) {
        Double amount = Double.valueOf(data.get("amount"));
        Account account = accountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (amount == null) {
            AccountOperation operation = new AccountOperation(OperationType.DEPOSIT, new Date(), 0, account.getBalance(), OperationStatus.FAILED);
            return new ResponseEntity(operation, HttpStatus.OK);
        }
        return new ResponseEntity(account.deposit(amount), HttpStatus.OK);
    }

    @PostMapping("/accounts/withdraw/{id}")
    public ResponseEntity<AccountOperation> moneyWithdraw(@PathVariable("id") Long id, @RequestBody Map<String, String> data) {
        Double amount = Double.valueOf(data.get("amount"));
        Account account = accountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (amount == null) {
            AccountOperation operation = new AccountOperation(OperationType.WITHDRAW, new Date(), 0, account.getBalance(), OperationStatus.FAILED);
            return new ResponseEntity(operation, HttpStatus.OK);
        }
        return new ResponseEntity(account.withdraw(amount), HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> listAccounts() {
        return new ResponseEntity(accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("/accounts/history/{id}")
    public ResponseEntity<List<AccountOperation>> accountHistory(@PathVariable("id") Long id) {
        Account account = accountService.findAccountById(id);
        if (account == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(account.getHistory(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountState> accountState(@PathVariable("id") Long id) {
        Account account = accountService.findAccountById(id);
        AccountState accountState = new AccountState(account.getId(), new Date(), account.getBalance());
        if (account == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountState>(accountState, HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount() {
        Account account = accountService.createAccount();
        return new ResponseEntity(account, HttpStatus.OK);
    }
}
