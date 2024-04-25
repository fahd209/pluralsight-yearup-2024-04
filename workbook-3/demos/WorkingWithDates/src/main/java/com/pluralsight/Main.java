package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args)
    {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getDayOfMonth());
        System.out.println(today.getMonth());
        System.out.println(today.getYear());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(today.format(formatter));

        timeOnly();
    }

    public static void timeOnly()
    {
        System.out.println();
        LocalTime now = LocalTime.now();
        System.out.println(now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        System.out.println(now.format(formatter));
        System.out.println(now.plusMinutes(5));
    }
}