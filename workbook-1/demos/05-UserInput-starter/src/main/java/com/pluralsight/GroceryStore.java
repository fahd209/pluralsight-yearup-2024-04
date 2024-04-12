package com.pluralsight;

import java.util.Scanner;

public class GroceryStore
{
    private static Scanner userInput = new Scanner(System.in);
    static final String PRODUCT_CHOCOLATE = "Milka Aplenmilch";
    static final double PRODUCT_CHOCOLATE_PRICE = 2.99;
    static final String PRODUCT_CANDY = "Skittles";
    static final double PRODUCT_CANDY_PRICE = 1.49;

    public static void main(String[] args)
    {

        // declare constants

        // input variables
        String customerName;
        int quantity;
        int productId;
        double cashReceived;

        // calculated
        double totalPrice = 0;
        double changeReturned;

        // get username
        customerName = getName();

        //display product
        displayProducts(customerName);

        // getting product id
        productId = getSelectedProductId();

        // getting selected number of quantity
        quantity = getSelectedQuantity();

        if(productId == 1)
        {
            totalPrice = PRODUCT_CHOCOLATE_PRICE * quantity;
        }
        else if(productId == 2)
        {
            totalPrice = PRODUCT_CANDY_PRICE * quantity;
        }
        else
        {
            System.out.println("Wrong number please choose between (1-2)");
        }

        // display total price and display total
        cashReceived = getCashAndDisplayTotal(totalPrice);

        //gets total and displays it
        changeReturned = getChange(totalPrice, cashReceived);

        // display the receipt
        System.out.println();
        System.out.printf("Welcome %s. \n", customerName);
        System.out.printf("Total:  $ %6.2f \n", totalPrice);
        System.out.printf("Cash:   $ %6.2f \n", cashReceived);
        System.out.printf("Change: $ %6.2f \n", changeReturned);
    }

    public static String getName()
    {
        // get user input
        System.out.print("Please enter your name: ");
        String customerName = userInput.nextLine(); // waits for the user to enter their name
        return customerName;
    }

    public static void displayProducts(String name)
    {
        System.out.println();
        System.out.printf("Welcome %s. Today's products are: \n", name);
        System.out.printf("1) %s - $ %.2f \n", PRODUCT_CHOCOLATE, PRODUCT_CHOCOLATE_PRICE);
        System.out.printf("2) %s - $ %.2f \n", PRODUCT_CANDY, PRODUCT_CANDY_PRICE);
        System.out.println();
    }

    public static int getSelectedProductId(){
        System.out.println("Please select a product: ");
        int productId = userInput.nextInt();
        return productId;
    }

    public static int getSelectedQuantity()
    {
        System.out.print("How many would you like to buy? ");
        int quantity = userInput.nextInt();
        return quantity;
    }

    public static double getCashAndDisplayTotal(double total){
        System.out.printf("The total is %.2f \n", total);

        System.out.print("Please enter your cash amount: ");
        double cashReceived = userInput.nextInt();
        return cashReceived;
    }

    public static double getChange(double total, double cashReceived)
    {

        double changeReturned = cashReceived - total;
        return changeReturned;
    }
}