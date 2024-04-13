package com.pluralsight;

import java.util.Scanner;

public class Main {
    // declaring variables
    static Scanner userInput = new Scanner(System.in);
    final static double regularSandWichPrice = 5.45;
    final static double largeSandWichPrice = 8.95;
    static double total = 0;
    static int age;
    final static double studentDistcount = 0.10;
    final static double seniorDiscount = 0.20;
    static double finaltotal = 0;
    static double discount;

    public static void main(String[] args)
    {
        // get sandwichsize
        int sandWichSize = getSandWichSize();

        //checkSize of sandwich and calulate total
        total = checkAndCalculate(sandWichSize);
        //System.out.println(total);

        //get user age
        age = getCustomerAge();
        //System.out.println("age: " + studentAge);

        // getting dicount
        discount = getDiscount();

        //applying discount and printing total
        printFinalTotal();

    }
    public static int getSandWichSize()
    {
        System.out.println("Menu: ");
        System.out.printf("1) Regular: %.2f \n 2) Large: %.2f \n", regularSandWichPrice, largeSandWichPrice);
        System.out.println("What size sandwich do you want? ");

        int size = userInput.nextInt();
        return size;
    }

    public static double checkAndCalculate(int sizeOfsandWich)
    {
        double total = 0;
        if(sizeOfsandWich == 1)
        {
            total = regularSandWichPrice;
        }
        else if (sizeOfsandWich == 2)
        {
            total = largeSandWichPrice;
        }
        else
        {
            System.out.println("Wrong number please choose between (1-2)");
        }
        return total;
    }

    public static int getCustomerAge()
    {
        System.out.println("How old are you? ");
        int age = userInput.nextInt();
        return age;
    }

    public static double getDiscount()
    {

        if(age <= 17)
        {
           discount  = total * studentDistcount;
            System.out.println("discount: %10");
        }
        else if(age >= 65)
        {
            discount = total * seniorDiscount;
            System.out.println("discount: %20");
        }
        return discount;
    }

    public static void printFinalTotal()
    {
        finaltotal = total - discount;
        System.out.println("Your total is: " + finaltotal);
    }

}