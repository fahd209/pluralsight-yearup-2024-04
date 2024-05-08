package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRoomsAvailable;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms)
    {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRoomsAvailable = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberSuites;
        this.numberOfRoomsAvailable = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public boolean BookRoom(int numberOfRooms, boolean isSuite)
    {
        if(isSuite)
        {
            if(numberOfRooms <= numberOfSuites)
            {
                this.numberOfSuites -= numberOfRooms;
                return true;
            }
        }
        else
        {
            if(numberOfRooms <= numberOfRoomsAvailable)
            {
                this.numberOfRoomsAvailable -= numberOfRooms;
                return true;
            }
        }
        return false;
    }

    public int getAvailableSuites()
    {
        return numberOfSuites;
    }

    public int getNumberOfRoomsAvailable()
    {
        return this.numberOfRoomsAvailable;
    }


}
