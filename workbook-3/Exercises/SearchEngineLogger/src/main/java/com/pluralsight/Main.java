package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    private static File logger = new File("files\\logs.txt");

    public static void main(String[] args)
    {
        promptUser();
    }

    public static void promptUser()
    {
        logLunch();

        String input = "";
        while(!input.equalsIgnoreCase("x")) {
            System.out.print("Enter a search term(X to exit): ");
            input = userInput.nextLine();
            logSearch(input);
        }

        // if the user enters x then we exit the application
        if(input.equalsIgnoreCase("x"))
        {
            logExit();
        }
    }

    public static void logLunch()
    {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");

        try(
                FileWriter inputStream = new FileWriter(logger, true);
                PrintWriter writer = new PrintWriter(inputStream);
                )
        {
            writer.println(currentDate.format(formatter) + " Application lunched");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static void logExit()
    {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");
        try(
                FileWriter inputStream = new FileWriter(logger, true);
                PrintWriter writer = new PrintWriter(inputStream);
        )
        {
            writer.println(currentDate.format(formatter) + " Application Exit");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

    public static void logSearch(String usersSearch)
    {
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");

        try(
            FileWriter inputStream = new FileWriter(logger, true);
            PrintWriter writer = new PrintWriter(inputStream);
                )
        {
            // checking if user didn't entered x so that we don't log it
            if(!usersSearch.equalsIgnoreCase("x"))
            {
                writer.println(currentDateAndTime.format(formatter) + " Searched : " + usersSearch);
            }
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}