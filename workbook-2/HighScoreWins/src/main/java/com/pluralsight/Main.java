package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        String score = getScore();
        String winner = findWinner(score);
        System.out.println("Winner: " + winner);
    }

    public static String getScore(){
        System.out.println("(Please type the score in the following format)");
        System.out.println("team1:team2|score1:score2 ex: home:visitor|21:9");

        String score = userInput.nextLine();
        return score;
    }

    public static String findWinner(String score){
        String[] scores = score.split("[|:]");
        String team1 = scores[0];
        String team2 = scores[1];
        String score1 = scores[2];
        String score2 = scores[3];

        int firstScore = Integer.parseInt(score1);
        int secondScore = Integer.parseInt(score2);
        //System.out.println(team1 + team2 );
        String winner = "";

        if(firstScore > secondScore){
            winner += team1;
        } else {
            winner += team2;
        }

        return winner;
    }
}