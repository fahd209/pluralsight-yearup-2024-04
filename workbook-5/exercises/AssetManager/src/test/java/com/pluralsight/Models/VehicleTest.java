package com.pluralsight.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    public void getValue_shouldReduce_TheCarValue_By3PercentPerEachYearOfTheVehicleAge_IfTheVehiclesAgeIsBetween0And3()
    {
        //arrange
        Vehicle test = new Vehicle("Test", "02/02/2022", 30000, "Honda accord", 2022, 10000);
        double expectedValue = 28200;

        //act
        double actualValue = test.getValue();

        //assert
        assertEquals(expectedValue, actualValue, "Because the vehicle is 2 years old");
    }

    @Test
    public void getValue_shouldReduce_TheCarValue_By25percentPlusTheVehiclesAgeReduce_IfIts_100000_milesOrOver()
    {
        //arrange
        Vehicle test = new Vehicle("Test", "02/02/2022", 80000, "bmw m4", 2022, 100000);
        double expectedValue = 56400;

        //act
        double actualValue = test.getValue();

        //assert
        assertEquals(expectedValue, actualValue, "Because the vehicle is over 100000");
    }

    @Test
    public void getValue_shouldNotReduce_TheCarValue_By25percent_IfThe_MakeMode_isAHondaOrToyota()
    {
        //arrange
        Vehicle test = new Vehicle("Test", "02/02/2022", 30000, "Honda accord", 2022, 100000);
        double expectedValue = 28200;

        //act
        double actualValue = test.getValue();

        //assert
        assertEquals(expectedValue, actualValue, "Because its a honda so it doesn't reduce the value by %25 if its over a 100k miles");
    }
}