package com.bank.bankaccount.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private Long id;
    private double balance;
    private static Long accountId;
    private List<AccountOperation> history;

    static  {
        accountId = 1L;
    }

    public Account() {
        this.id= accountId++;
        this.history = new ArrayList();
    }

    public Account(double initialBalance) {
        this();
        this.balance = initialBalance;
    }

    public AccountOperation deposit(double amount) {
        double newBalance = getBalance() + amount;
        setBalance(newBalance);
        AccountOperation operation = new AccountOperation(OperationType.DEPOSIT, new Date(), amount, newBalance, OperationStatus.SUCCESS);
        history.add(operation);
        return operation;
    }

    public AccountOperation withdraw(double amount) {
        AccountOperation operation;
        if (amount > balance) {
            operation = new AccountOperation(OperationType.WITHDRAW, new Date(), amount, getBalance(), OperationStatus.FAILED);
        } else {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            operation = new AccountOperation(OperationType.WITHDRAW, new Date(), amount, newBalance, OperationStatus.SUCCESS);
            history.add(operation);
        }
        return operation;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static Long getAccountId() {
        return accountId;
    }

    public static void setAccountId(Long accountId) {
        Account.accountId = accountId;
    }

    public List<AccountOperation> getHistory() {
        return history;
    }

    public void setHistory(List<AccountOperation> history) {
        this.history = history;
    }
}
