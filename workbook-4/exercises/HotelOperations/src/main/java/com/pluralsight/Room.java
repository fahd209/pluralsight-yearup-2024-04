package com.pluralsight;

public class Room {
    private int numberOfBed;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBed, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBed = numberOfBed;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBed() {
        return numberOfBed;
    }

    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable()
    {
        return !isDirty && !isOccupied;
    }

    public void checkIn()
    {
        this.isOccupied = true;
        this.isDirty = true;
    }

    public void checkOut()
    {
        this.isOccupied = false;
    }

    public void cleanRoom()
    {
        this.isDirty = false;
    }
}
