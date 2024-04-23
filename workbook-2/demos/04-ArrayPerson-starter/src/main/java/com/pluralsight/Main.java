package com.pluralsight;

import java.util.Scanner;

public class Main
{
    static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // create an array of people here
        Person[] people = {
                new Person("John", "Doe", 30),
                new Person("Jane", "Smith", 25),
                new Person("Michael", "Johnson", 40),
                new Person("Emily", "Brown", 35),
                new Person("David", "Wilson", 28)
        };

        int choice = 0;
        while(choice != 6)
        {
            // print the home screen
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("1 - List all people");
            System.out.println("2 - Search by lastName");
            System.out.println("3 - Search by age range");
            System.out.println("4 - Add new person");
            System.out.println("5 - Quit");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(userInput.nextLine());

            switch(choice)
            {
                case 1:
                    // list all
                    showAll(people);
                    break;
                case 2:
                    // search by name
                    searchByLastName(people);
                    break;
                case 3:
                    // search by age
                    searchByAge(people);
                    break;
                case 4:
                    // add person
                    addPerson(people);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Bruh... not an option");
                    break;
            }

        }


    }

    public static void showAll(Person[] people)
    {
        for(int i = 0; i < people.length; i++){
        System.out.printf("%-10s %-10s %d \n", people[i].getFirstName(), people[i].getLastName(), people[i].getAge());
    }
    }

    public static void searchByLastName(Person[] people)
    {
        System.out.println("Enter last name: ");
        String lastName = userInput.nextLine();
        System.out.println();
        System.out.println("Searching by last name...");
        System.out.println("-------------------------");

        for(int i = 0; i < people.length; i++){
            if(people[i].getLastName().equalsIgnoreCase(lastName)){
                System.out.printf("%-10s %-10s %d \n", people[i].getFirstName(), people[i].getLastName(), people[i].getAge());
            }
        }
    }

    public static void searchByAge(Person[] people)
    {
        System.out.println("Enter min age: ");
        int min = userInput.nextInt();
        //userInput.nextLine();

        System.out.println("Enter max age: ");
        int max = userInput.nextInt();
        userInput.nextLine();
        System.out.println();
        System.out.println("Searching by age range...");
        System.out.println("-------------------------");

        for(int i = 0; i < people.length; i++){
            if(people[i].getAge() >= min && people[i].getAge() <= max){
                System.out.printf("%-10s %-10s %d \n", people[i].getFirstName(), people[i].getLastName(), people[i].getAge());
            }
        }
    }

    public static void addPerson(Person[] people)
    {
        // get user input

        // create a person

        // add to the list
    }
}
