package com.pluralsight;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        promptUserForStory();
    }

    public static void promptUserForStory()
    {
        System.out.println("What story would you like to read? Enter one of the following titles -> (goldilocks, hansel and gretel, mary had a little lamb)");
        String storyName = userInput.nextLine().replace(" ", "_").toLowerCase();

        disPlayStory(storyName+".txt");
    }

    public static void disPlayStory(String storyName)
    {
        File file = new File("files\\"+storyName);

            try(Scanner fileReader = new Scanner(file))
            {
                while(fileReader.hasNext()){
                    String line = fileReader.nextLine();
                    System.out.println(line);
                }
            }
            catch (IOException e)
            {
                while (!file.exists()){
                    System.out.println("File does not exist. please make sure the story's name is exact as the following");
                    promptUserForStory();

                }
            }



    }
}