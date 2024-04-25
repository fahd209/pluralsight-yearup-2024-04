package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("files/employees.csv");

        try(
                FileInputStream fileReader = new FileInputStream(file);
                Scanner reader = new Scanner(fileReader);
                )
        {
            reader.nextLine();



            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] columns = line.split("[|]");

                int id = Integer.parseInt(columns[0]);
                String name = columns[1];
                double hoursWorked = Double.parseDouble(columns[2]);
                double payRate = Double.parseDouble(columns[3]);

                System.out.println(name + " worked " + hoursWorked + " this week");
                reader.nextLine();

            }
        }
        catch (IOException e)
        {
            System.out.println("File does not exist");
        }
    }
}