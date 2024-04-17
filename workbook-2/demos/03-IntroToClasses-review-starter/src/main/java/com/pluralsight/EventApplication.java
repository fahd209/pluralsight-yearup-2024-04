package com.pluralsight;

import com.pluralsight.models.*;

import java.util.Scanner;

public class EventApplication
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        Person eventGear = register();
        greetGuest(eventGear);
        //System.out.println(eventGear.getFirstName());
        eventGear.work(2);
        displayGuestInfo(eventGear);
    }

    public static Person register()
    {
        //declare variables

        String fullName, firstName, lastName;
        int age;
        System.out.println("Please enter your full name: ");
        fullName = userInput.nextLine();

        System.out.println("Please enter your age: ");
        age = userInput.nextInt();
        userInput.nextLine(); // clearing out the memory stream

        // get first and last name
        String[] names = fullName.split(" ");
        firstName = names[0];
        lastName = names[1];

        //create a person
        Person person = new Person(firstName, lastName, age);

        return person;
    }

    public static void greetGuest(Person guest)
    {
        System.out.println();
        System.out.printf("Welcome %s %s", guest.getFirstName(), guest.getLastName());
    }

    public static void displayGuestInfo(Person guest){
        System.out.println();
        System.out.println("Guest Information");
        System.out.println("---------------------------------------");
        System.out.println("First name: " + guest.getFirstName());
        System.out.println("Last name: " + guest.getLastName());
        System.out.println("Age: " + guest.getAge());
        System.out.println("Energy: " + guest.getEnergy());
    }
}