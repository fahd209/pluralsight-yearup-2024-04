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
        int accountNumber = UserInterface.getAccountNumber();
        BankAccount account = bankAccounts.stream()
                                          .filter(acct -> acct.getAccountNumber() == accountNumber)
                                          .findFirst()
                                          .get();

        double amount = UserInterface.getWithdrawalAmount();
        boolean canWithdraw = account.canWithdraw(amount);
        if(canWithdraw)
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

    public void deposit()
    {
        int accountNumber = UserInterface.getAccountNumber();
        BankAccount bankAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .get();

        double depositAmount = UserInterface.getDepositAmount();
        bankAccount.deposit(depositAmount);

    }

    public void transfer()
    {
        int firstAccountNumber = UserInterface.getFirstAccountNumber();
        int secondAccountNumber = UserInterface.getSecondAccountNumber();

        BankAccount fromAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == firstAccountNumber)
                .findFirst()
                .get();

        BankAccount toAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == secondAccountNumber)
                .findFirst()
                .get();

        double transferAmount = UserInterface.getTransferAmount(fromAccount, toAccount);

        fromAccount.transfer(toAccount, transferAmount);
    }

    public void addNewAccount()
    {
        String accountType = UserInterface.getNewAccountType();
        int accountNumber = UserInterface.getNewAccountNumber();
        String ownerName = UserInterface.getNewAccountOwner();
        double balance = 0;

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
        int accountNumber = UserInterface.getAccountNumber();

        BankAccount bankAccount = bankAccounts.stream()
                .filter(a -> a.getAccountNumber() == accountNumber)
                .findFirst()
                .get();

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
