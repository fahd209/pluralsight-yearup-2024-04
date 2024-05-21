package com.pluralsight.models;

import com.pluralsight.interfaces.PowerTool;

public class RidingMower extends Vehicle implements PowerTool {

    public RidingMower(String make, String model)
    {
        super(make, model);
    }

    @Override
    public void repair()
    {
        System.out.println("Repairing ridingMower ... Overrides vehicle and powertool");
    }
}
