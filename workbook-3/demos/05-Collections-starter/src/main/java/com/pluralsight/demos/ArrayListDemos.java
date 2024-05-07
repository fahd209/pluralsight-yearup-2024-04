package com.pluralsight.demos;

import com.pluralsight.io.CityLoader;
import com.pluralsight.models.City;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListDemos
{
    public static void main(String[] args)
    {
    }

    public static void basicArrayList()
    {
        ArrayList<String> heroes = new ArrayList<String>();
        heroes.add("Spider-Man");
        heroes.add("Iron Man");
        heroes.add("Thor");
        heroes.add("Thor");
        heroes.add("Thor");

        while(heroes.contains("Thor"))
        {
            heroes.remove("Thor");
        }
        System.out.println(heroes);

//        heroes.add("Captain America");
//        heroes.add("Hulk");
//        heroes.add("Black Widow");
//        heroes.add("Hawkeye");
//        heroes.add("Ant-Man");
//        heroes.add("Wasp");
//        heroes.add("Black Panther");
//        heroes.add("Doctor Strange");
//        heroes.add("Scarlet Witch");
//        heroes.add("Vision");
//        heroes.add("Falcon");
//        heroes.add("Winter Soldier");
//        heroes.add("Star-Lord");
//        heroes.add("Gamora");
//        heroes.add("Drax the Destroyer");
//        heroes.add("Rocket Raccoon");
//        heroes.add("Groot");
    }

    public static void displayCities()
    {

    }

    public static void displayCountrysAsSet()
    {
        //City city = new City();
        CityLoader cityLoader = new CityLoader();
        HashMap<String, Integer> countries = new HashMap<>();
        ArrayList<City> cities = cityLoader.loadCities();

        for(City c : cities)
        {
            String key = c.getCountry();
            if(countries.containsKey(key)) //<== if Hashmap countains the country then we increment the value by 1
            {
                countries.put(key, countries.get(key) + 1);
            }
            else
            {
                countries.put(key, 1);
            }
        }

    }

}
