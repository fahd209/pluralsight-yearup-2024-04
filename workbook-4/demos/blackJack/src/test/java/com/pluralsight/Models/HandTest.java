package com.pluralsight.Models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    public void deal_should_increaseCardCount()
    {
        //arrange
        Hand hand = new Hand("Hassan");
        Card card = new Card("Diamonds", "9");
        Card card2 = new Card("Spades", "A");

        // act
        hand.deal(card);
        hand.deal(card2);

        // assert
        int expectedCardCount = 2;
        int cardCount = hand.getCardCount();
        assertEquals(expectedCardCount, cardCount, "Because we only dealt 1 card");

        ArrayList<Card> cards = hand.getCards();
        assertTrue(cards.contains(card), "Because the 9 of diamonds should be in the list of cards");
        assertTrue(cards.contains(card2), "Because the A of Spades should be in the list of cards");
    }
}