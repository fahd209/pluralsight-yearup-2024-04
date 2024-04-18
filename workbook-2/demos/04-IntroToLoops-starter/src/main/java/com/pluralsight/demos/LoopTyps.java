package com.pluralsight.demos;
import java.util.Scanner;

public class LoopTyps {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        //whileLoop();
        //doWhileLoop();
        whileLoop10();
    }

    public static void whileLoop()
    {
        System.out.println("Do you want to play? (y/n)");
        String playAgain = userInput.nextLine().strip().toLowerCase();

        while(playAgain.equalsIgnoreCase("y")){
            System.out.println("Welcome to my game");

            System.out.println();
            System.out.println("Do you want to play again (y/n)");
            playAgain = userInput.nextLine().strip().toLowerCase();
        }

        System.out.println("Thanks for playing my game!");

    }

    public static void doWhileLoop()
    {
        String playAgain = "y";

        do {
            System.out.println("Welcome to my game");

            System.out.println();
            System.out.println("Do you want to play again (y/n)");
            playAgain = userInput.nextLine().strip().toLowerCase();
        }while(playAgain.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing my game!");

    }

    public static void whileLoop10(){
        int counter = 0;

        while(counter < 10){
            System.out.println(counter);
            counter++;
        }
    }

    public static void forLoop(){
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}
