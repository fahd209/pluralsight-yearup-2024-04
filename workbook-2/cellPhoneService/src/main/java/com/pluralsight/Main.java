package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);
    static CellPhone phone = new CellPhone();
    public static void main(String[] args) {



        //System.out.println("Hello world!");
        Long serialNum = getSerialNum();
        phone.setSerialNumber(serialNum); //<== setting serial num to serialNum input

        String model = getModel();
        phone.setModel(model); //<== getting model and setting it to model inside the cellphone object


        //System.out.println(phone.getSerialNumber());

        String carrier = getCarrier();
        phone.setCarrier(carrier); //<== getting carrier and setting it to carrier inside the cellphone object

        String phoneNumber = getNumber();
        phone.setPhoneNumber(phoneNumber); //<== getting phoneNumber and setting it to phoneNumber inside cellPhone object

        String owner = getOwner();
        phone.setOwner(owner); // <== getting owner and setting owner to owner inside the cellPhone object

        printCellPhone();
    }

    public static Long getSerialNum(){
        System.out.println("What is the serial number? ");
        Long serialNum = userInput.nextLong();
        userInput.nextLine();

        return serialNum;
    }

    public static String getModel(){
        System.out.println("What model is the phone? ");
        String model = userInput.nextLine();

        return model;
    }

    public static String getCarrier(){
        System.out.println("Who is your carrier? ");
        String carrier = userInput.nextLine();

        return carrier;
    }

    public static String getNumber(){
        System.out.println("What is your phone number? ");
        String phoneNum = userInput.nextLine();

        return phoneNum;
    }

    public static String getOwner(){
        System.out.println("Who is the owner of the phone? Please enter fullname");
        String owner = userInput.nextLine();

        return owner;
    }

    public static void printCellPhone(){
        System.out.println();
        System.out.println("Phone information");
        System.out.println("-------------------------------------------");
        System.out.println("Serial number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }
}