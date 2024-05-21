package com.pluralsight;

import com.pluralsight.interfaces.Drivable;
import com.pluralsight.models.RidingMower;
import com.pluralsight.models.Truck;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Drivable> arrayList = new ArrayList<>();
        arrayList.add(new Truck("Toyota", "Tacoma"));
        arrayList.add(new RidingMower("Mower", "ft250"));

        for(Drivable drivable: arrayList)
        {
            drivable.repair();
        }

    }
}