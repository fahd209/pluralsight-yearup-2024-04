package com.pluralsight;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //1. I need to get the file path
        String filePath = "files\\mary_had_a_little_lamb.txt";

        //2. I need to have an object the points to the file
        File file = new File(filePath);


        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        //3. I need a file reader to open the file
        try(Scanner fileScanner = new Scanner(file))
        {
            int wordCount = 0;
            while(fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");
                wordCount += words.length;
                System.out.println(line);
            }
            System.out.println("There is " + wordCount + " words");
        }
        catch (Exception e)
        {
            System.out.println("File does not exist");
        }

    }
}