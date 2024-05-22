package com.pluralsight.finance;

public class House extends FixedAsset{
    private int yearBuilt;
    private int squareFeet;
    private int bedRooms;

    public House(String name, double valuePerSquareFoot, int yearBuilt, int squareFeet, int bedRooms) {
        super(name, valuePerSquareFoot);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedRooms = bedRooms;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public int getBedRooms() {
        return bedRooms;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    @Override
    public double getValue()
    {
        return getMarketValue() * getSquareFeet();
    }

    public String toString()
    {
        return String.format(" name: %s | value: %.2f ",getName(), getValue());
    }

}
