package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        //declaring objects

        CellPhone phone1 = new CellPhone();
        CellPhone phone2;
        //CellPhone phone3 = new CellPhone(12365, "Iphone 8", "verizon", "2036541236", "Aliiii");

        // getting serial num for phone 1
        Long serialNum = getSerialNum();
        phone1.setSerialNumber(serialNum); //<== setting serial num to serialNum input

        //getting model for phone 1
        String model = getModel();
        phone1.setModel(model); //<== getting model and setting it to model inside the cellphone object

        // getting carrier for phone 1
        String carrier = getCarrier();
        phone1.setCarrier(carrier); //<== getting carrier and setting it to carrier inside the cellphone object

        //getting phone number for phone 1
        String phoneNumber = getNumber();
        phone1.setPhoneNumber(phoneNumber); //<== getting phoneNumber and setting it to phoneNumber inside cellPhone object

        // getting owner for phone 1
        String owner = getOwner();
        phone1.setOwner(owner); // <== getting owner and setting owner to owner inside the cellPhone object

        // getting serial num for phone 2
        System.out.println();
        System.out.println("Phone 2");
        System.out.println("-------------");
        Long serialNum2 = getSerialNum();
       // phone2.setSerialNumber(serialNum2);

        //getting model for phone 2
        String model2 = getModel();
        //phone2.setModel(model2);

        // getting carrier for phone 2
        String carrier2 = getCarrier();
        //phone2.setCarrier(carrier);

        //getting phone number for phone 2
        String phoneNumber2 = getNumber();
       // phone2.setPhoneNumber(phoneNumber2);

        // getting owner for phone 2
        String owner2 = getOwner();
        //phone2.setOwner(owner2);
        phone2 = new CellPhone(serialNum2, model2, carrier2, phoneNumber2,owner2);

        // displaying phones
        printCellPhone(phone1);
        System.out.println();
        System.out.println("Phone 2");
        printCellPhone(phone2);

        // calling
        phone1.dial( phone2.getPhoneNumber() );
        phone2.dial( phone1.getPhoneNumber() );
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
        System.out.println("Who is the owner of the phone? Please enter full name");
        String owner = userInput.nextLine();

        return owner;
    }

    public static void printCellPhone(CellPhone phone){
        System.out.println();
        System.out.println("Phone information");
        System.out.println("-------------------------------------------");
        System.out.println("Serial number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
        System.out.println();
    }
}