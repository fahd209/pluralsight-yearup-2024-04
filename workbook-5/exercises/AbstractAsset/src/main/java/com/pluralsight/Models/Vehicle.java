package com.pluralsight.Models;

import java.time.LocalDate;

public class Vehicle extends Asset {
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue()
    {
        LocalDate currentDate = LocalDate.now();
        double currentYear = currentDate.getYear();
        double vehicleAge = currentYear - getYear();
        double value = 0;

        if(vehicleAge <= 3)
        {
            value = calculateValue(vehicleAge, 0.03);
        } else if (vehicleAge >= 4 && vehicleAge <= 6)
        {
            value = calculateValue(vehicleAge, 0.06);
        }
        else if (vehicleAge >= 7 && vehicleAge <= 10)
        {
            value = calculateValue(vehicleAge, 0.08);
        }
        else
        {
            value = 1000;
        }


        if(!getMakeModel().toLowerCase().contains("toyota") && !getMakeModel().toLowerCase().contains("honda"))
        {
            if(getOdometer() >= 100000)
            {
                value = value * (1 - 0.25);
            }
        }
        return value;
    }

    public double calculateValue(double vehicleAge, double percent)
    {
        double value = getOriginalCost();
        double percentByYear = vehicleAge * percent;

        return value * (1 - percentByYear);
    }
}
