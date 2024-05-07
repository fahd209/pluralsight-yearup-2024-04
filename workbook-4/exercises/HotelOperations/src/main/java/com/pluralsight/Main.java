package com.pluralsight;

public class Main {
    public static void main(String[] args)
    {

        Room room1 = new Room(1,200,false,false);
        System.out.println("Is room available: " + room1.isAvailable());

        Reservation reservation1 = new Reservation("king", 2,false);
        System.out.println("Reservation price: " + reservation1.getPrice());


        Employee employee1 = new Employee("123456", "Fahd", "Software", 20, 40);
        System.out.println("Over time hours: " + employee1.getOverTimeHours());
        System.out.println("total pay: " + employee1.getTotalPay());
    }
}