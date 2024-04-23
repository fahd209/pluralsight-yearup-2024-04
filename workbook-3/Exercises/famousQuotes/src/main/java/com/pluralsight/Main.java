package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String[] quotes = {
                "\"The only way to do great work is to love what you do.\" - Steve Jobs",
                "\"In the end, it's not the years in your life that count. It's the life in your years.\" - Abraham Lincoln",
                "\"Believe you can and you're halfway there.\" - Theodore Roosevelt",
                "\"The greatest glory in living lies not in never falling, but in rising every time we fall.\" - Nelson Mandela",
                "\"Success is not final, failure is not fatal: It is the courage to continue that counts.\" - Winston Churchill",
                "\"The only limit to our realization of tomorrow will be our doubts of today.\" - Franklin D. Roosevelt",
                "\"Life is what happens when you're busy making other plans.\" - John Lennon",
                "\"The best way to predict the future is to create it.\" - Peter Drucker",
                "\"Do not go where the path may lead, go instead where there is no path and leave a trail.\" - Ralph Waldo Emerson",
                "\"The only person you should try to be better than is the person you were yesterday.\" - Anonymous"
        };
        getQuotesNumber(quotes);
    }
    public static void getQuotesNumber(String[] quotes)
    {
        int index = 1;
        while(index != 0){
            try
            {
                System.out.println("Enter a number 1 - 10 for a qoute: ");
                String qouteNumInput = userInput.nextLine();
                index = Integer.parseInt(qouteNumInput);

                if(index != 0){
                    System.out.println(quotes[index - 1]);
                }

            }catch (NumberFormatException e)
            {
                System.out.println("Invalid input please enter a valid input");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid input please enter a number 1 - 10");
            }
        }
    }
}