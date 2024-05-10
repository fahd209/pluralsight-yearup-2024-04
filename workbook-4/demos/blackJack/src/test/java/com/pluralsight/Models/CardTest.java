package com.pluralsight.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void getColor_shouldReturnRed_forHearts()
    {
        //Arrange
        Card card = new Card("Hearts", "Q");

        //act
        String color = card.getColor();

        // assert
        String expectedColor = "Red";
        assertEquals(expectedColor, color);
    }

    @Test
    public void getPoint_shouldReturn10_forQueen()
    {
        //Arrange
        Card card = new Card("Hearts", "Q");

        //act
        int cardPointValue = card.getPointValue();

        // assert
        int expectedPointValue = 10;
        assertEquals(expectedPointValue, cardPointValue);
    }

    @Test
    public void getPoint_shouldReturn11_forAce()
    {
        //Arrange
        Card card = new Card("Hearts","A");

        //Action
        int cardPointValue = card.getPointValue();

        //assert
        int expectedPointValue = 11;
        assertEquals(expectedPointValue, cardPointValue);
    }

    @Test
    public void getColor_shouldReturnBlack_ifTheSuitIsNotHeartOrDiamonds()
    {
        //arrange
        Card card = new Card("Club", "A");
        String expectedColor = "Black";

        //act
        String cardColor = card.getColor();

        //assert

        assertEquals(expectedColor, cardColor);
    }

}