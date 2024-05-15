package com.pluralsight.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    public void getValue_shouldReturn_450000_If_The_Sqaure_Foot_OfTheHouse_Is5000SqaureFoot_AndIfTheConditionIsFair()
    {
        // arrange
        House house = new House("Test", "02/25/2022", 1000000, "941 w aldrich", 3, 5000, 0);
        double expectValue = 450000;

        //act
        double actualValue = house.getValue();

        //assert
        assertEquals(expectValue, actualValue, "Because the house condition was 3 (fair) and it was 5000 square foot");
    }

    @Test
    public void getValue_should_add_25CentPerSquareFootOfLotSizeIfTheHouseHasALot()
    {
        House house = new House("Test", "02/25/2022", 800000, "941 w aldrich", 1, 2500, 10);
        double expectedValue = 450002.5;

        //act
        double actualValue = house.getValue();

        //assert
        assertEquals(expectedValue, actualValue, "Because the square foot of the house is 2500 and the lot is 10 square foot, also the condition is 1 (excellent)");
    }
}