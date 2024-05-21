package com.pluralsight.models;

public class Square extends Rectangle
{
    public Square(int sideLength)
    {
        super("Square", sideLength, sideLength);
    }


    @Override
    public double getArea()
    {
        return getHeight() * getHeight();
    }

    @Override
    public String toString()
    {
        return String.format("%s (Height: %d x width: %d) area: %.2f", getName(), getHeight(), getHeight(), getArea());
    }
}
