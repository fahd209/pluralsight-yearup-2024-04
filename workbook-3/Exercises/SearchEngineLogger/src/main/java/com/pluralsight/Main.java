package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    private static File logger = new File("files\\logs.txt");
    private static LocalDate currentDate = LocalDate.now();
    private static LocalTime currentTime = LocalTime.now();

    public static void main(String[] args)
    {
        promptUser();
    }

    public static void promptUser()
    {
        logLunch();

        String input = "";
        while(!input.equalsIgnoreCase("x")) {
            System.out.println("Enter a search term(X to exit): ");
            input = userInput.nextLine();
            logSearch(input);
        }

        if(input.equalsIgnoreCase("x"))
        {
            logExit();
        }
    }

    public static void logLunch()
    {
        try(
                FileWriter inputStream = new FileWriter(logger);
                PrintWriter writer = new PrintWriter(inputStream);
                )
        {
            writer.println(currentDate + " " + currentTime + " Application lunched");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static void logExit()
    {
        try(
                FileWriter inputStream = new FileWriter(logger, true);
                PrintWriter writer = new PrintWriter(inputStream);
        )
        {
            writer.println(currentDate + " " + currentTime + " Application closed");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

    public static void logSearch(String usersSearch)
    {

    }
}