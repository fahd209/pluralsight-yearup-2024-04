package com.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        // declare variables for each of the following:

        // a vehicle identification number in the range 1000000 - 9999999
        long identificationNum = Math.round(Math.random() * 9999999) + 1000000;
        System.out.println("The id number of the vehicle is: " + identificationNum);

        // a vehicle make /model (i.e. Ford Explorer)
        String make = "Honda";
        String model = "accord";

        System.out.println("The vehicle make is " + make + " and the model is " + model);

        // a vehicle color
        String color = "red";
        System.out.println("The vehicle color is " + color);

        // whether the vehicle has a towing package
        boolean vehicleHasTowingPackage = false;
        System.out.println("Does the vehicle have a towing package? " + vehicleHasTowingPackage);

        // an odometer reading


        // a price
        double vehiclePrice = 50000;
        System.out.println("The vehicles price is " + vehiclePrice);

        // a quality rating (A, B, or C)
        char quality = 'A';
        System.out.println("The vehicles rating is " + quality);

        // a phone number
        long phoneNumber = 2095632145;
        System.out.println("Phone: " + phoneNumber);

        // a social security number
        int SSN = 125530258;
        System.out.println("SSN: " + SSN);

        // a zip code
        int zipCode = 95630;
        System.out.println("Zip code: " + zipCode);


    }
}