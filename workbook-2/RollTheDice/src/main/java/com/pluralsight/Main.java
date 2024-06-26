package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        // declaring variables
        Dice dice = new Dice();
        int roll1;
        int roll2;

        int twoCounter = 0;
        int fourCounter = 0;
        int sixCounter = 0;
        int sevenCounter = 0;

        // looping 100x, checking, sum and adding count
        for(int i = 1; i <= 20; i++){
            roll1 = dice.roll();
            roll2 = dice.roll();
            int sum = roll1 + roll2;

            System.out.println("Roll " + i + ": " + roll1 + " - " + roll2 + " sum: " + sum);

            if(sum == 2){
                twoCounter++;
            } else if (sum == 4){
                fourCounter++;
            } else if(sum == 6){
                sixCounter++;
            } else if(sum == 7){
                sevenCounter++;
            }

        }

        System.out.println();
        System.out.println("Counters");
        System.out.println("--------------------");
        System.out.println("Two: " + twoCounter);
        System.out.println("Four: " + fourCounter);
        System.out.println("Six: " + sixCounter);
        System.out.println("Seven: " + sevenCounter);
    }
}