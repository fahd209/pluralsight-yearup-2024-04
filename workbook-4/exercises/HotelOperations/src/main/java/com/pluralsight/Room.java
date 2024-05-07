package com.pluralsight;

public class Room {
    int numberOfBed;
    double price;
    boolean isOccupied;
    boolean isDirty;

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
        boolean isAvailable = !isDirty && !isOccupied ? true : false;
        return isAvailable;
    }
}