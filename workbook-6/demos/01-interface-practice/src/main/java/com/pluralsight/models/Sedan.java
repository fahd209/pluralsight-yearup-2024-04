package com.pluralsight.models;

public class Sedan extends Vehicle{

    public Sedan(String make, String model)
    {
        super(make, model);
    }

    @Override
    public void repair()
    {
        System.out.println("Repairing sedan");
    }
}
