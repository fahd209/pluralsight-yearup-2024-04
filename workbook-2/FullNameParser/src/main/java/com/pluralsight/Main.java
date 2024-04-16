package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String fullName = getFullName(); //<== what ever getFullName func returns is stored in fullName.
        printNames(fullName); // printing first, middle, and last name by passing fullName into the printNames func.
    }

    public static String getFullName(){
        System.out.println("Enter your full name in this format (First-name Last-name) or (FirstName MiddleName LastName)");
        String fullName = userInput.nextLine().strip().replace("  ", " ");

        return fullName;
    }

    public static void printNames(String fullName){
        String name[] = fullName.split(" ");
        String firstName = name[0];
        //String middle;
        String lastName = "";
        String middleName = "";
        if(name.length > 2){
            middleName = name[1];
            lastName = name[2];

        } else  {
            lastName = name[1];
        }
        
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }
}