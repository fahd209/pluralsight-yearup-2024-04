package com.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        House house1 = new House("Gray", "Tan");

        house1.paintOutside("Yellow");

        System.out.println("The color of my house is " + house1.getOutsideColor());
    }
}