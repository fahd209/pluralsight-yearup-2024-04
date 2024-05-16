package com.pluralsight;

import com.pluralsight.Models.Asset;
import com.pluralsight.Models.House;
import com.pluralsight.Models.Vehicle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Asset> assets = new ArrayList<>();
        assets.add(new House("My house", "02/02/2006" , 1000000, "922 s lincoln", 3, 5000, 10));
        assets.add(new House("Vacation house", "05/26/2008", 800000, "288 w aldrich", 1, 2500, 10));
        assets.add(new Vehicle("dads car", "06/21/2020", 30000, "Toyota camry", 2020, 125000));
        assets.add(new Vehicle("My car", "02/21/2022", 80000, "Bmw m4", 2022, 100000));

        display(assets);
    }

    public static void display(ArrayList<Asset> assets)
    {
        for(Asset asset : assets)
        {
            if(asset instanceof House) // <= checking if the asset is a house
            {
                System.out.println("Description: " + asset.getDescription());
                System.out.println("Date acquired: " + asset.getDatAcquired());
                System.out.println("Address: " + ((House) asset).getAddress()); // <== converting the asset to a house to have access getAddress method
                System.out.println("Original cost: $" + asset.getOriginalCost());
                System.out.println("Current value: $" + asset.getValue());
                System.out.println();
            } else if (asset instanceof Vehicle) {
                System.out.println("Description: " + asset.getDescription());
                System.out.println("Date acquired: " + asset.getDatAcquired());
                System.out.println("Make / Model: " + ((Vehicle) asset).getMakeModel());
                System.out.println("Original cost: $" + asset.getOriginalCost());
                System.out.println("Current value: $" + asset.getValue());
                System.out.println();
            }
        }
    }
}