package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void accelerate_Should_NotChangeSpeed_WithNegativeInputs()
    {
        // arrange
        Car car = new Car("Ford", "Mustang");
        int increaseBy = 10;
        int expectedSpeed = 20;


        //action
        car.accelerate(increaseBy);
        car.accelerate(increaseBy);

        //assert
        int speed = car.getSpeed();
        assertEquals(expectedSpeed, speed);
    }

}