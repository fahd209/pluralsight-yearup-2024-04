package com.pluralsight;

public class ExerciseDemo
{
    public static void main(String[] args)
    {
        question1();
        question2();
    }

    public static void question1()
    {
        // calculate the amount of change given after buying chocolate
        // chocolate costs 2.99
        // I have $20
        // buy 4 bars of chocolate
        // how much change will I get back?
        double balance = 20;
        int quantity = 4;
        double chocolatePrice = 2.99;
        double change;
        double totalCost;

        totalCost = quantity * chocolatePrice;

        change = balance - totalCost;

        System.out.println("Chocolate Bar: $ " + chocolatePrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("----------------------------------");
        System.out.println("Total $ " + totalCost);
        System.out.println("Change $" + change);
    }

    public static void question2()
    {
        // calculate the perimeter of a circle
        double radius = 12;
        double perimeter;

        // calculate
        perimeter = 2 * Math.PI * radius;
        System.out.println("The perimeter of a circle with a radius of "+ radius + " is " + perimeter);
    }

}

