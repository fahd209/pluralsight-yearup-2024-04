package com.pluralsight;

import java.util.Scanner;

public class Main
{
    static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // create an array of vehicles here
        Vehicle[] vehicles = {
                new Vehicle(19873, "Honda accord", "black", 50000, 15000),
                new Vehicle(84798, "Toyota camry", "red", 50000, 20000)
        };


        int choice = 0;
        while(choice != 6)
        {
            // print the home screen
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.println();
            System.out.print("Enter your command: ");
            choice = Integer.parseInt(userInput.nextLine());

            switch(choice)
            {
                case 1:
                    // call the list all vehicles (pass the array)
                    listAllVehicles(vehicles);
                    break;
                case 2:
                    // call the search by make/model
                    searchByMakeModel(vehicles);
                    break;
                case 3:
                    // call the search by price
                    searchByPrice(vehicles);
                    break;
                case 4:
                    // call the search by color
                    searchByColor(vehicles);
                    break;
                case 5:
                    // add a vehicle
                    vehicles = addVehicle(vehicles);
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid selection");
                    break;
            }

            System.out.println();
            System.out.println("Enter to continue...");
            userInput.nextLine();

        }

    }

    public static void listAllVehicles(Vehicle[] vehicles)
    {
        // loop through vehicles and print all
        System.out.println();
        System.out.println("All vehicles");
        System.out.println("----------------------");
        for(int i = 0; i < vehicles.length; i++){
            Vehicle vehicle = vehicles[i];
            System.out.printf("|| Id: %d, Make model: %s, Color: %s, Odometer Reading: %d, Price: $%.2f ||\n ", vehicles[i].getVehicleId(), vehicles[i].getMakeModel(), vehicles[i].getColor(), vehicles[i].getOdometerReading(), vehicles[i].getPrice());
        }
    }

    public static void searchByMakeModel(Vehicle[] vehicles)
    {
        // get user search criteria
        System.out.println();
        System.out.println("Search vehicle by Make model");
        System.out.println("----------------------------------------");
        System.out.println("What's the make and model for your car ");
        String makeModel = userInput.nextLine();

        // loop through vehicles and print only vehicles that match the search
        for(int i = 0; i < vehicles.length; i++){
            if(makeModel.equalsIgnoreCase(vehicles[i].getMakeModel())){
                System.out.printf(" || Id: %d, Make model: %s, Color: %s, Odometer Reading: %d, Price: $%.2f || ", vehicles[i].getVehicleId(), vehicles[i].getMakeModel(), vehicles[i].getColor(), vehicles[i].getOdometerReading(), vehicles[i].getPrice());
            }
        }
    }

    public static void searchByPrice(Vehicle[] vehicles)
    {
        // get user search criteria
        System.out.println("Search vehicle by price");
        System.out.println("---------------------------------------");
        System.out.println("What is the price of the your vehicle? ");
        double price = userInput.nextDouble();
        userInput.nextLine();

        // loop through vehicles and print only vehicles that match the search
        for(int i = 0; i < vehicles.length; i++){
            boolean validVehicalPrice = vehicles[i].getPrice() == price;
            if(validVehicalPrice){
                System.out.printf(" || Id: %d, Make model: %s, Color: %s, Odometer Reading: %d, Price: $%.2f || \n ", vehicles[i].getVehicleId(), vehicles[i].getMakeModel(), vehicles[i].getColor(), vehicles[i].getOdometerReading(), vehicles[i].getPrice());
            }
        }

    }

    public static void searchByColor(Vehicle[] vehicles)
    {
        // get user search criteria
        System.out.println("Search vehicle by color");
        System.out.println("-----------------------------------");
        System.out.println("What is the color of your vehicle? ");
        String color = userInput.nextLine();

        // loop through vehicles and print only vehicles that match the search
        for(int i = 0; i < vehicles.length; i++){
            if(color.equalsIgnoreCase(vehicles[i].getColor())){
                System.out.printf(" || Id: %d, Make model: %s, Color: %s, Odometer Reading: %d, Price: $%.2f || \n ", vehicles[i].getVehicleId(), vehicles[i].getMakeModel(), vehicles[i].getColor(), vehicles[i].getOdometerReading(), vehicles[i].getPrice());
            }
        }
    }

    // bonus (optional)
    public static Vehicle[] addVehicle(Vehicle[] vehicles)
    {
        // get user input
        System.out.println("What is the Id of the car you want to add? ");
        Long id = userInput.nextLong();
        userInput.nextLine();

        System.out.println("What is the Make and Model of the vehicle? ");
        String MakeModel = userInput.nextLine();

        System.out.println("What is the color of the vehicle? ");
        String color = userInput.nextLine();

        System.out.println("What is the odometer reading of the vehicle? ");
        int odometerReading = userInput.nextInt();

        System.out.println("What is the price of the vehicle? ");
        double price = userInput.nextDouble();
        userInput.nextLine();

        // create a vehicle
        Vehicle newVehicle = new Vehicle(id, MakeModel, color, odometerReading, price);

        // add it to the inventory
        // temp array
        Vehicle[] temp = new Vehicle[vehicles.length + 1];

        //copy vehicles array to temp array;
        for(int i = 0; i < vehicles.length; i++){
            temp[i] = vehicles[i];
        }

        // adding newVehicle to temp array
        temp[vehicles.length] = newVehicle;

        // add tempArr to vehicles arr
        vehicles = temp;

        return vehicles;
    }
}