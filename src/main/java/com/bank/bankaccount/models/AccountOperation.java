package com.bank.bankaccount.models;

import java.util.Date;

public class AccountOperation {

    private OperationType operationType;
    private Date operationDate;
    private double amount;
    private double balance;
    private OperationStatus operationStatus;

    public AccountOperation(OperationType operationType, Date operationDate, double amount, double balance,OperationStatus operationStatus) {
        this.operationType = operationType;
        this.operationDate = operationDate;
        this.amount = amount;
        this.balance = balance;
        this.operationStatus = operationStatus;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }
}
