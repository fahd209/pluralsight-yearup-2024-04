package com.pluralsight;

public class MathApp
{
    public static void main(String[] args)
    {
        // find all 7 questions in your workbook on page 
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
        question7();

    }

    // write ONLY code for QUESTION 1 in this function
    public static void question1()
    {
        // Question 1:
        // declare variables here
        double bobSalary = 100000;
        double garySalary = 120000;

        // code the logic to the problem here
        double highestSalary = Math.max(bobSalary, garySalary);

        // printing highest salary;
        System.out.println("The highest salary is " + highestSalary);

        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
    }


    // write ONLY code for QUESTION 2 in this function
    public static void question2()
    {
        // Question 2:
        // declare variables here
        double carPrice = 10000;
        double truckPrice = 30000;
        double cheapestPrice;
        // code the logic to the problem here
        cheapestPrice = Math.min(carPrice, truckPrice);
        // Printin cheapest price
        System.out.println("The cheapest price is " + cheapestPrice);
        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
    }


    // write ONLY code for QUESTION 3 in this function
    public static void question3()
    {
        // Question 3:
        // Variables
        double radius = 7.25;
        double area;

        // code the logic to the problem here
        area = Math.PI * Math.pow(radius, 2);
        //printing area
        System.out.println("The area of the circle is " + area);
        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
    }


    // write ONLY code for QUESTION 4 in this function
    public static void question4()
    {
        // Question 4:
        // declare variables here
        double squareNumber = 5.0;
        double squareRoot;
        // code the logic to the problem here
        squareRoot = Math.sqrt(squareNumber);

        // printing squareRoot
        System.out.println("The square root is " + squareRoot);
        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
    }


    // write ONLY code for QUESTION 5 in this function
    public static void question5()
    {
        // Question 5:
        // declare variables here
        double x1 = 5;
        double y1 = 10;
        double x2 = 85;
        double y2 = 50;

        // code the logic to the problem here
        double a = x2 - x1; //<== width
        double b = y2 - y1; //<== height;
        double c = Math.pow(a, 2) + Math.pow(b, 2);
        double distance = Math.sqrt(c);

        //printing distance
        System.out.println("The distance between points (5,10) and (85,50) is " + distance);
        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);

    }


    // write ONLY code for QUESTION 6 in this function
    public static void question6()
    {
        // Question 6:
        // declare variables here
        double negativeNumber = -3.8;
        double absolutePostiveNum;
        // code the logic to the problem here
        absolutePostiveNum = Math.abs(negativeNumber);

        //printing absolute postive number
        System.out.println("The absolute positive number of " + negativeNumber + " is "+ absolutePostiveNum);

        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
    }


    // write ONLY code for QUESTION 7 in this function
    public static void question7()
    {
        // Question 7:
        // declare variables here
        double randomNumber;

        //code the logic
        randomNumber = Math.round(Math.random()); //<== setting the number to 0 and 1 by getting the number and then rounding it.

        //Printing randomNumber
        System.out.println("The random number is going to be: " + randomNumber);

        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
    }
}