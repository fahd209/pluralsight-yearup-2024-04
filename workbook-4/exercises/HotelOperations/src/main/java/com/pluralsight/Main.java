package com.pluralsight;

import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        System.out.println();
        Room room1 = new Room(1,200,false,false);
        room1.checkIn();
        System.out.println("Is available: " + room1.isAvailable());

        System.out.println();
        Reservation reservation1 = new Reservation("king", 2,false);
        System.out.println("Reservation price: " + reservation1.getPrice());

        System.out.println();
        Employee employee1 = new Employee("123456", "Fahd", "Software", 20, 40);
        System.out.println("Over time hours: " + employee1.getOverTimeHours());
        System.out.println("total pay: " + employee1.getTotalPay());
        employee1.punchTimeCard(10.0);
        employee1.punchTimeCard(14.75);
        employee1.punchIn();
        employee1.punchOut();

        System.out.println();
        Hotel hotel = new Hotel("Year up hotel", 50, 50);
        System.out.println("is room booked: " + hotel.BookRoom(4, false));
        System.out.println("Available rooms: " + hotel.getNumberOfRoomsAvailable());
        System.out.println("Available suites: " + hotel.getAvailableSuites());

    }
}