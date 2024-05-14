package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        String name[] = getFullName();
        LocalDate reservation = getReservation();
        int numberOfTickets = getNumOfTickets();
        printReservation(name, reservation, numberOfTickets);
    }

    public static String[] getFullName(){
        System.out.println("Enter your full name: ");
        String name[] = userInput.nextLine().split(" ");

        return name;
    }

    public static LocalDate getReservation(){
        System.out.println("What date will you be coming (MM/dd/yyyy)");
        String dateInput = userInput.nextLine(); //<== getting user input
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //<== setting formate to (MM/dd/yyyy)

        LocalDate reservation = LocalDate.parse(dateInput, formatter); //<== parsing the dateInput to the format above
        //System.out.println(reservation);
        return reservation;
    }

    public static int getNumOfTickets(){
        System.out.println("How many tickets would you like? ");
        int numOfTickets = userInput.nextInt();

        return numOfTickets;
    }

    public static void printReservation(String name[], LocalDate reservation, int numberOfTickets){
        System.out.println(numberOfTickets + " tickets reserved for " + reservation + " under " + name[1] + ", " + name[0]);
    }
}