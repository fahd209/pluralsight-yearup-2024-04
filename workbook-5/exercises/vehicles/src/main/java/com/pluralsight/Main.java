package com.pluralsight;

public class Main {
    public static void main(String[] args)
    {
        // I am able to access the properties of my vehicle
        // class because HoverCraft, moped, and semiTrack inherit from the vehicle class

        Moped slowRide = new Moped("blue", 2, 2, 12);

        SemiTruck semiTruck = new SemiTruck("Red", 2, 4, 16);

        System.out.println("My moped fuel capacity is " + slowRide.getFuelCapacity() + " galons");
        System.out.println("My semi truck could fit " +semiTruck.getCargoCapacity() + " passengers");
    }
}