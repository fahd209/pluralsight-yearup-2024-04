package com.pluralsight;

import java.util.Scanner;

public class Main {
    // display the product
    // ask user for their name
    // ask for quantity
    // calculate total and display
    // ask for money
    // give change back

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        // declare variables
        final String PRODUCT = "Milka Aplenmilch";
        final double PRICE = 2.99;

        // input variables
        int quantity;
        String customerName;
        double cashReceived;

        // calculated
        double totalPrice;
        double changeReturned;

        //get user input
        System.out.print("Please enter your name: ");
        customerName = userInput.nextLine();

        System.out.printf("The product of the day is %s for $ %.2f each. \n ", PRODUCT, PRICE);

        System.out.print("How many do you need? ");
        quantity = userInput.nextInt();

        System.out.println("Please enter your cash amount: ");
        cashReceived = userInput.nextInt();

        // calculations
        totalPrice = PRICE * quantity;
        cashReceived = 20;
        changeReturned = cashReceived - totalPrice;

        // display the receipt
        System.out.println("Welcome " + customerName);
        System.out.printf("Total: $ %6.2f \n ", totalPrice);
        System.out.printf("Cash: $ %6.2f \n ", cashReceived);
        System.out.printf("Change: $ %6.2f \n ", changeReturned);

    }
}