package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @org.junit.jupiter.api.Test
    void getNumberOfBed() {
    }

    @Test
    public void whenCheckedIn_It_shouldSetIsOccupiedAndIsDirtyToTrue()
    {
       // arrange
       Room roomTest = new Room(2, 140, false, false);
       // <== expecting the checking in to work

       //act
        roomTest.checkIn();

       //assert
        assertTrue(roomTest.isOccupied(), "Room is occupied");
        assertTrue(roomTest.isDirty(), "Room is dirty");
    }

    @Test
    public void checkIn_should_setIsAvailableToFalse()
    {
        //arrange
        Room room = new Room(2, 140, false, false);

        // act
        room.checkIn();

        //assert
        boolean actual = room.isCheckedIn();
        assertFalse(room.isAvailable());
    }

    @Test
    public void whenCheckedIn_RoomShouldBeSetToCheckedIn()
    {
        // arrange
        Room room = new Room(2,120,false,false);

        // action
        room.checkIn();

        //assert
        assertTrue(room.isCheckedIn());
    }

    @Test
    public void checkOut_shouldNotWork_ifCheckInIsFalse()
    {
        //arrange
        Room room = new Room(1,100, false, false);

        //action
        room.checkOut();

        //assert
        assertFalse(room.isCheckedIn());
    }

    @Test
    public void whenCheckedOut_RoomShouldNotBeOccupied()
    {
        //arrange
        Room room = new Room(1,140,false, false);

        // action
        room.checkIn();
        room.checkOut();

        //assert
        assertFalse(room.isOccupied());

    }

    @Test
    public void cleanRoom_shoudSet_IsDirtyToFalse()
    {
        //arrange
        Room room = new Room(1,150,false,false);

        //actions
        room.checkIn();
        room.checkOut();
        room.cleanRoom();

        //
        assertFalse(room.isDirty());
    }
}