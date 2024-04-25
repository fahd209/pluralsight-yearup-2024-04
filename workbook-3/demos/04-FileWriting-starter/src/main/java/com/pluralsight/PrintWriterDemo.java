package com.pluralsight;

import java.io.*;

public class PrintWriterDemo
{
    public static void main(String[] args)
    {
        String[] languages = {"Java", "C#", "JavaScript", "Python", "SQL"};
        String[] moreWords = {"HTML", "CSS", "Bootstrap"};
        writeToFile(languages);
        writeToFile(moreWords);
    }

    public static void writeToFile(String[] words)
    {
        File file = new File("files/programming-languages-print-writer.txt");

        try(FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter writer = new PrintWriter(fileWriter);
        )
        {
            for(String line : words)
            {
                // works like System.out.printxxx()
                writer.println(line);
            }
        }
        catch(IOException ex)
        {

        }
    }
}
