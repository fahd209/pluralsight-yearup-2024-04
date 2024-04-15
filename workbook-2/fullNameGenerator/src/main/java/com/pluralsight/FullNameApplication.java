package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        String firstName = getFirstName();
        String MiddleName = getMiddleName();
        String lastName = getLastName();
        String suffix = getSuffix();


        printFullName(firstName, MiddleName, lastName, suffix);

    }

    public static String getFirstName(){
        System.out.println("Enter your first name: ");
        String firstName = userInput.nextLine().strip();


        return firstName;
    }

    public static String getMiddleName(){
        System.out.println("Enter your middle name: ");
        String middleName = userInput.nextLine().strip().toUpperCase();

        if(!middleName.isEmpty()){
            middleName += ".";
        }

        return middleName;
    }

    public static String getLastName(){
        System.out.println("Enter your last name: ");
        String lastName = userInput.nextLine().strip();
        return lastName;
    }

    public static String getSuffix(){
        System.out.println("Suffix: ");
        String suffix = userInput.nextLine();


        return suffix;
    }

    public static void printFullName(String firstName, String MiddleName, String lastName, String suffix){
        if(!suffix.isEmpty()){
            lastName += ",";
        }

        String fullName = "Full name: " + firstName + " " + MiddleName + " " + lastName + " " + suffix;
        fullName = fullName.replace("  ", " ");
        System.out.println(fullName);
    }
}