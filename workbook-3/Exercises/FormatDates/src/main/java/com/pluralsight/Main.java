package com.pluralsight;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args)
    {
        displayDateNumberedFormat();
        displayDateLetterDateFormat();
        displayDateAndTime();
    }
    public static void displayDateNumberedFormat()
    {
        System.out.println("Date");
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(formatter));
    }

    public static void displayDateLetterDateFormat()
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(today.format(formatter));
    }

    public static void displayDateAndTime()
    {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm a");
        System.out.println(today.format(formatter));
    }
}