package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        int[] testScore = {10,50,60,20,30,100,90};

        int average = findAverage(testScore);
        System.out.println("Average: " + average);

        int highScore = getHighScore(testScore);
        System.out.println("Highest score: " + highScore);

        int lowScore = getLowestScore(testScore);
        System.out.println("Lowest score: " + lowScore);
    }
    public static int findAverage(int[] array){
        int average = 0;
        for(int i = 0; i < array.length; i++){
            average += array[i];
        }
        return average / array.length;
    }

    public static int getHighScore(int[] array){
        int highScore = 0;
        for(int i = 0; i < array.length; i++){
            highScore = Math.max(highScore, array[i]);
        }
        return highScore;
    }

    public static int getLowestScore(int[] array){
        int lowestScore = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            lowestScore = Math.min(lowestScore, array[i]);
        }
        return lowestScore;
    }
}