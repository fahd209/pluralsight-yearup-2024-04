package com.pluralsight;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args)
    {
        disPlayDateAndTime();
    }
    public static void disPlayDateAndTime()
    {
        LocalDate currentDate = LocalDate.now();
        LocalTime time = LocalTime.now();

        DayOfWeek day = currentDate.getDayOfWeek();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");

        System.out.println(day +", " + currentDate.format(formatter) + " " + time.format(timeFormatter));
    }
}