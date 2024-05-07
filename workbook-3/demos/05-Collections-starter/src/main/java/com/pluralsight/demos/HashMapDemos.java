package com.pluralsight.demos;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemos
{
    public static void main(String[] args) {
        simpleMap();
    }
    public static void simpleMap()
    {
        HashMap<String, Integer> supplies = new HashMap<>();

        supplies.put("Markers", 9);
        supplies.put("Scissors", 15);

        for(String key : supplies.keySet())
        {
            int value = supplies.get(key);
            System.out.println(key + " : " + value);
        }

        for (Map.Entry<String, Integer> row : supplies.entrySet())
        {
            System.out.println(row);
        }
    }

}
