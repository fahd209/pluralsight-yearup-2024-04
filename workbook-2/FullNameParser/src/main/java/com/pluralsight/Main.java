package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String fullName = getFullName();
        String name[] = fullName.split(" ");
        String firstName = name[0];
        if(name.length){

        }
        String middle = name[1];
        String lastName = name[2];

        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middle);
        System.out.println("Last name: " + lastName);

    }

    public static String getFullName(){
        System.out.println("Enter your full name in this format (First-name Last-name) or (FirstName MiddleName LastName)");
        String fullName = userInput.nextLine().strip().replace("  ", " ");

        return fullName;
    }
}