package com.pluralsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // calling the read file method
        promptUserForProcessFile();
    }
    
    public static void promptUserForProcessFile()
    {
        System.out.println("Available files for processing");
        System.out.println("------------------------------");
        System.out.println("         employees.csv        ");
        System.out.println();
        System.out.print("Enter the name of the file you would like to process: ");
        String processFileName = userInput.nextLine();
        System.out.println("Enter the name of the file you would like to create, enter file type as (.json for json file or .csv for csv file) ");
        System.out.print("Enter input: ");
        String fileName = userInput.nextLine();
        readFile(processFileName, fileName);
    }
    public static void readFile(String processFileName, String newFileName)
    {
        // checking if they did not enter the file type
        if(!processFileName.contains(".csv"))
        {
            processFileName += ".csv";
        }

        File file = new File("files\\" + processFileName);

        try(Scanner fileReader = new Scanner(file))
        {
            //skipping the first line
            fileReader.nextLine();
            while(fileReader.hasNext())
            {
                String line = fileReader.nextLine();
                String[] columns = line.split("[|]");
                String employeeID = columns[0];
                String name = columns[1];
                double hours = Double.parseDouble(columns[2]);
                double pay = Double.parseDouble(columns[3]);

                // creating an object of employee with the data from the csv file
                Employee employee = new Employee(employeeID, name, hours, pay);
                //adding it to the array
                employees.add(employee);

            }

            //calling my print function to print out the array
            createFile(employees, newFileName);
        }
        catch (IOException e)
        {
            System.out.println("File does not exist");
        }
    }

    public static void createFile(ArrayList<Employee> employees, String fileName)
    {
        //checking file type
        if(fileName.contains(".csv"))
        {
            createCsvFile(employees, fileName);
        }
        else if (fileName.contains(".json"))
        {
            createJsonFile(employees, fileName);
        }
    }

    public static void createCsvFile(ArrayList<Employee> employees, String fileName)
    {
        File payRollFile = new File("files\\" + fileName);
        try(FileWriter writer = new FileWriter(payRollFile);
            PrintWriter printWriter = new PrintWriter(writer);
        )
        {
            // looping through employees object and printing in the file
            System.out.println();
            System.out.println("Creating file " + fileName);
            for (int i = 0; i < employees.size(); i++){
                printWriter.printf("Id: %-2s | Name: %-20s | Gross: %4.2f \n ",employees.get(i).getEmployeeID(), employees.get(i).getName(), employees.get(i).getGrossPay());
            }
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    public static void createJsonFile(ArrayList<Employee> employees, String fileName)
    {
        File payRollFile = new File("files\\" + fileName);
        StringBuilder stringJson = new StringBuilder();

        try(
                FileWriter writer = new FileWriter(payRollFile);
            PrintWriter printWriter = new PrintWriter(writer);
        )
        {
            // looping through employees object and printing in the file
            System.out.println();
            System.out.println("Creating file " + fileName);
            for (int i = 0; i < employees.size(); i++){

                String json = "";

                // checking if i is at the last object
                if(i != employees.size() - 1) {
                    json = "{\"Id\": " + employees.get(i).getEmployeeID() + ", \"Name\": " + "\"" + employees.get(i).getName() + "\"" + ", \"Gross\": " + employees.get(i).getGrossPay() + " },\n";
                } else {
                    json = "{\"Id\": " + employees.get(i).getEmployeeID() + ", \"Name\": " + "\"" + employees.get(i).getName() + "\"" + ", \"Gross\": " + employees.get(i).getGrossPay() + " }\n";
                }

                //appending json string to stringbuilder
                stringJson.append(json);
            }
            printWriter.println("[" + stringJson + "]");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}