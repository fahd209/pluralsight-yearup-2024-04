package com.pluralsight.ui;

import com.pluralsight.Models.Card;
import com.pluralsight.Models.Hand;

import java.util.ArrayList;

public class UserInterface {
    public static void displayAllPlayersCards(ArrayList<Hand> players)
    {
        System.out.println("All Players");
        System.out.println("-".repeat(30));

        for(Hand player : players)
        {
            System.out.println(player.getPlayerName() + ": " + player.getPointValue());
            for(Card card : player.getCards())
            {
                System.out.println(" " + card.getFaceValue() + " of " + card.getSuit());
            }
        }
    }

    public static void displayWinner(Hand winner)
    {
        System.out.println("*".repeat(50));
        System.out.println("Winner: " + winner.getPlayerName());
        System.out.println("*".repeat(50));
    }
}
