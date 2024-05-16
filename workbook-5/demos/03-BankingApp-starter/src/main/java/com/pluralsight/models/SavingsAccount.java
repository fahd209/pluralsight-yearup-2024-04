package com.pluralsight.models;

public class SavingsAccount extends BankAccount{
    private static final double MIN_BALANCE = 25;
    public SavingsAccount(int accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    public boolean canWithdraw(double amount)
    {
        double newBalance = getBalance() - amount;
        return newBalance >= MIN_BALANCE;
    }

    @Override
    public double withdraw(double amount)
    {
        if(canWithdraw(amount))
        {
            return super.withdraw(amount);
        }

        return getBalance();
    }
}
