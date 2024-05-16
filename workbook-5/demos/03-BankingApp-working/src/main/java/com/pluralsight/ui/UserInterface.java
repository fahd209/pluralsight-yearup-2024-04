package com.pluralsight.ui;

import com.pluralsight.models.BankAccount;

import java.util.Scanner;

public class UserInterface
{
    private static Scanner in = new Scanner(System.in);

    public static int getHomeScreenSelection()
    {
        System.out.println();
        System.out.println("Welcome to the bank");
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println(" 1) withdraw");
        System.out.println(" 2) deposit");
        System.out.println(" 3) transfer");
        System.out.println(" 4) add account");
        System.out.println(" 5) display account balance");
        System.out.println(" 0) exit");
        System.out.print("Enter your selection: ");
        return Integer.parseInt(in.nextLine());
    }

    public static int getAccountNumber()
    {
        System.out.println();
        System.out.print("Please enter the account number: ");
        return Integer.parseInt(in.nextLine());
    }

    public static double getWithdrawalAmount()
    {
        System.out.println();
        System.out.print("Please enter the amount to withdraw: ");
        return Double.parseDouble(in.nextLine());
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public static double getDepositAmount()
    {
        System.out.println();
        System.out.print("Enter deposit amount: ");
        return Double.parseDouble(in.nextLine());
    }

    public static int getFirstAccountNumber()
    {
        System.out.println();
        System.out.print("Enter the first accounts number: ");
        return Integer.parseInt(in.nextLine());
    }

    public static int getSecondAccountNumber()
    {
        System.out.println();
        System.out.print("Enter the seconds account number: ");
        return Integer.parseInt(in.nextLine());
    }

    public static double getTransferAmount(BankAccount fromAccount, BankAccount toAccount)
    {
        System.out.println();
        System.out.println("Hi " + fromAccount.getOwner() + ", how much do you want to send to " + toAccount.getOwner());
        System.out.print("Enter amount: ");
        return Double.parseDouble(in.nextLine());
    }

    public static String getNewAccountType()
    {
        System.out.println();
        System.out.println("What type of account are you opening? (Checkings, Savings)");
        System.out.print("Enter input: ");
        return in.nextLine();
    }

    public static int getNewAccountNumber()
    {
        System.out.println();
        System.out.println("What will be this account's number? ");
        System.out.print("Enter input: ");
        return Integer.parseInt(in.nextLine());
    }

    public static String getNewAccountOwner()
    {
        System.out.println();
        System.out.println("Enter the owners name: ");
        return in.nextLine();
    }
}
