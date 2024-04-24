package com.pluralsight;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        readFile("files/goldilocks.txt");
    }

    public static void readFile(String filePath)
    {
        File file = new File(filePath);
        StringBuilder builder = new StringBuilder();
        try
        {
            FileInputStream fileStream = new FileInputStream(file);
            Scanner fileScanner = new Scanner(fileStream);
           while(fileScanner.hasNext())
           {
               String line = fileScanner.nextLine();
               builder.append(line + "\n");
           }

        }
        catch (Exception e)
        {
            System.out.println("File does not exist");
        }
        System.out.println(builder.toString());
    }
}