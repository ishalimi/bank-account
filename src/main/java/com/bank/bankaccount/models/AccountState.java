package com.bank.bankaccount.models;

import java.util.Date;

public class AccountState {
    private Long id;
    private Date stateDate;
    private double balance;

    public AccountState(Long id, Date stateDate, double balance) {
        this.id = id;
        this.stateDate = stateDate;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
