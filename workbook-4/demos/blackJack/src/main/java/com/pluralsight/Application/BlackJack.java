package com.pluralsight.Application;

import com.pluralsight.Models.Card;
import com.pluralsight.Models.Deck;
import com.pluralsight.Models.Hand;
import com.pluralsight.ui.UserInterface;

import java.util.ArrayList;

public class BlackJack {

    Deck deck = new Deck();
    ArrayList<Hand> players = new ArrayList<Hand>();
    Hand winner = new Hand("No winner");

    public void run()
    {
        addPlayers();
        dealCards();
        UserInterface.displayAllPlayersCards(players);
        findWinner();
        UserInterface.displayWinner(winner);
    }

    private void addPlayers()
    {
        players.add(new Hand("Hassan"));
        players.add(new Hand("Guy"));
        players.add(new Hand("Alexis"));
        players.add(new Hand("Angelica"));
    }

    private void dealCards()
    {
        deck.shuffle();

        for(int i = 0; i < 2; i++)
        {
            for (Hand player : players)
            {
                Card card = deck.takeCard();
                player.deal(card);
            }
        }
    }

    private void findWinner()
    {
        for(Hand player : players)
        {
            int points = player.getPointValue();
            if(points > winner.getPointValue() && points <= 21)
            {
                winner = player;
            }
        }
    }

}
