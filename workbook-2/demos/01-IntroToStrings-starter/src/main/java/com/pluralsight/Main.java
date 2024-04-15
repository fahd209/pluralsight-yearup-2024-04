package com.pluralsight;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //phoneNumberFormat();
        commonMethods();
        readProductSku();
    }

    public static void commonMethods(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String fullName = userInput.nextLine().strip();
        System.out.println("--" + fullName + "--");

        System.out.println("Please enter your phone number: ");
        String phone = userInput.nextLine()
                        .replace("-","")
                        .replace("(","")
                        .replace(")", "")
                        .replace(" ", "")
                        .replace(".", "");

        System.out.println("Phone: " + phone);
    }

    public static void phoneNumberFormat() {
        String phoneNumber = "8885551212";
        String formattedPhone;

        String firstThree = phoneNumber.substring(0,3);
        String nextThree = phoneNumber.substring(3,6);
        String last4 = phoneNumber.substring(6,10);

        System.out.println("First 3: " + firstThree);
        System.out.println("Next 3: " + nextThree);
        System.out.println("Last 4: " + last4);

        //formattedPhone = "(" + firstThree + ")" + nextThree + "-" + last4;
        formattedPhone = String.format("(%s) %s-%s", firstThree, nextThree, last4);
        System.out.println(formattedPhone);
    }

    public static void readProductSku(){
        String sku = "A123-LRG-1299";
        String size = findSize(sku);
        System.out.println("Size: " + size);

        String price = findPrice(sku);
        System.out.println("Price: " + price);
    }

    public static String findSize(String sku){
        int index = sku.indexOf("-"); // finds the position of the FIRST - in the text
        int lastIndex = sku.lastIndexOf("-"); // finds the position of the LAST - in the text

        String size = sku.substring(index + 1, lastIndex);

        return size;
    }

    public static String findPrice(String sku){
        int lastIndex = sku.lastIndexOf("-");
        String price = sku.substring(lastIndex + 1);

        return price;
    }
}