package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            Scanner userInput = new Scanner(System.in);

            System.out.print("Please enter your name: ");
            String name = userInput.nextLine();

            System.out.println("Please enter your age: ");
            String ageInput = userInput.nextLine();
            int age = Integer.parseInt(ageInput);

            System.out.printf("Welcome %s you are %d years old", name, age);

            String[] names = {"Fahd", "Julian", "Ismail"};
            System.out.println("Pick names 1 - 3");
            int index = userInput.nextInt();
            System.out.println(names[index]);

        }catch (NumberFormatException e)
        {
            System.out.println("Please enter a valid number for age: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Something went wrong." + e.getMessage());
        }
        finally
        {
            // clear up
            // close an open file
            // disconnect from database
        }

    }
}