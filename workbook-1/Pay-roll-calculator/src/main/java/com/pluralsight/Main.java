package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //variables
        Scanner userInput = new Scanner(System.in);
        String username;
        double hoursWorked;
        double payRate;
        double gross;
        double overTimeHours = 0;
        double overTimePay = 0;

        // get username
        System.out.println("Hello, Please enter your name: ");
        username = userInput.nextLine();

        // user hours worked
        System.out.printf("Hello %s, how many hours did you work this week? ", username);
        hoursWorked = userInput.nextDouble();


        // Calculate user's pay
        System.out.println("What is your pay rate hourly? ");
        payRate = userInput.nextDouble();
        if(hoursWorked > 40){
            overTimeHours = hoursWorked - 40;
            hoursWorked -= overTimeHours;
            //System.out.println(overTimeHours);
            overTimePay = overTimeHours * (payRate * 1.5);
            //System.out.println(overTimePay);
        }
        gross = overTimePay + (payRate * hoursWorked);

        //printing user's pay and hours
        System.out.println("Regular hours: " + hoursWorked);
        System.out.println("Over time: " + overTimeHours);
        System.out.printf("Your gross for %.2f Regular hours and %.2f over time hours is $ %.2f",hoursWorked, overTimeHours ,gross );

        userInput.close();
    }
}