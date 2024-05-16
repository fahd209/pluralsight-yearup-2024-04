package com.pluralsight.application;

import com.pluralsight.models.BankAccount;
import com.pluralsight.models.CheckingAccount;
import com.pluralsight.models.SavingsAccount;
import com.pluralsight.services.AccountFileService;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;

public class BankApplication
{
    private ArrayList<BankAccount> bankAccounts;

    public BankApplication()
    {
        bankAccounts = AccountFileService.loadAccounts();
    }

    public void run()
    {
        while(true)
        {
            int choice = UserInterface.getHomeScreenSelection();

            switch(choice)
            {
                case 1: // withdraw
                    // search by account number
                    // withdraw money from the account
                    withdraw();
                    break;
                case 2: // deposit
                    // search by account number
                    // deposit money into the account
                    deposit();
                    break;
                case 3: // transfer
                    // search for BOTH accounts
                    // transfer money from one account to another
                    transfer();
                    break;
                case 4: // create new account
                    // prompt user for account information
                    // add a new account to the list
                    addNewAccount();
                    break;
                case 5: // display balance
                    // search for account
                    // display account information and balance
                    accountInfo();
                    break;
                case 0:
                    // write to file
                    AccountFileService.saveAccounts(bankAccounts);
                    return;
            }
        }

    }

    public void withdraw()
    {
        //searching for account with account number
        int accountNumber = UserInterface.getAccountNumber();

        var result = bankAccounts.stream()
                                  .filter(acct -> acct.getAccountNumber() == accountNumber)
                                  .findFirst();

        if(result.isPresent())
        {
            BankAccount account = result.get();
            double amount = UserInterface.getWithdrawalAmount();
            boolean canWithdraw = account.canWithdraw(amount);
            if (canWithdraw)
            {
                account.withdraw(amount);
                UserInterface.displayMessage(amount + " was withdrawn");
                UserInterface.displayMessage("Remaining Balance: " + account.getBalance());
            }
            else
            {
                UserInterface.displayMessage("Sorry, you don't got enough");
            }
        }
    }

    public void deposit()
    {
        //searching for account with account number
        int accountNumber = UserInterface.getAccountNumber();
        BankAccount bankAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .get();

        // adding the deposit to the account that was return from the search
        double depositAmount = UserInterface.getDepositAmount();
        bankAccount.deposit(depositAmount);

    }

    public void transfer()
    {
        // getting first account and second account number
        int firstAccountNumber = UserInterface.getFirstAccountNumber();
        int secondAccountNumber = UserInterface.getSecondAccountNumber();

        // searching for accounts with numbers
        BankAccount fromAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == firstAccountNumber)
                .findFirst()
                .get();

        BankAccount toAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == secondAccountNumber)
                .findFirst()
                .get();

        // getting transfer amount
        double transferAmount = UserInterface.getTransferAmount(fromAccount, toAccount);

        // making the transfer
        fromAccount.transfer(toAccount, transferAmount);
    }

    public void addNewAccount()
    {
        // getting account info
        String accountType = UserInterface.getNewAccountType();
        int accountNumber = UserInterface.getNewAccountNumber();
        String ownerName = UserInterface.getNewAccountOwner();
        double balance = 0;

        //checking if It's a saving or checking then adding to the arrayList
        if(accountType.equalsIgnoreCase("savings"))
        {
            BankAccount bankAccount = new SavingsAccount(accountNumber, ownerName, 0);
            bankAccounts.add(bankAccount);
        }
        else
        {
            BankAccount bankAccount = new CheckingAccount(accountNumber, ownerName, 0);
            bankAccounts.add(bankAccount);
        }
    }

    public void accountInfo()
    {
        // getting account number
        int accountNumber = UserInterface.getAccountNumber();

        BankAccount bankAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .get();

        // checking if account is checking or saving then displaying info
        if(bankAccount instanceof CheckingAccount)
        {
            System.out.println();
            System.out.println("Owner: " + bankAccount.getOwner());
            System.out.println("Balance: " + bankAccount.getBalance());
            System.out.println("Type: Checking");
        }
        else {
            System.out.println();
            System.out.println("Owner: " + bankAccount.getOwner());
            System.out.println("Balance: " + bankAccount.getBalance());
            System.out.println("Type: Savings");
        }
    }
}
