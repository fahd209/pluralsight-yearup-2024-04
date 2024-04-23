package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args)
    {
        readFile();
    }
    public static void readFile()
    {
        File file = new File("files\\employees.csv");

        try(Scanner fileReader = new Scanner(file))
        {
            fileReader.nextLine();
            while(fileReader.hasNext())
            {
                String line = fileReader.nextLine();
                String[] columns = line.split("[|]");
                String employeeID = columns[0];
                String name = columns[1];
                double hours = Double.parseDouble(columns[2]);
                double pay = Double.parseDouble(columns[3]);

                Employee employee = new Employee(employeeID, name, hours, pay);
                employees.add(employee);

            }
            printfile(employees);
        }
        catch (IOException e)
        {
            System.out.println("File does not exist");
        }
    }
    public static void printfile(ArrayList<Employee> employees)
    {
        for (int i = 0; i < employees.size(); i++){
            System.out.printf("Id: %s | Name: %s | Gross: %.2f \n ",employees.get(i).getEmployeeID(), employees.get(i).getName(), employees.get(i).getGrossPay());
        }
    }
}