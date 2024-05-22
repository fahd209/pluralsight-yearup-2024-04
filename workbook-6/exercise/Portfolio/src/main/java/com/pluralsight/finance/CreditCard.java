package com.pluralsight.finance;

import com.pluralsight.finance.interfaces.Valuable;

public class CreditCard implements Valuable {
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(String name, String accountNumber, double balance)
    {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void charge(double amount)
    {
        balance -= amount;
    }

    public void pay(double amount)
    {
        balance += amount;
    }

    @Override
    public double getValue()
    {
        return -balance;
    }

    public String toString()
    {
        return String.format(" name: %s, balance: %.2f ",getName(), getBalance() );
    }

}
