package com.pluralsight.finance;

import com.pluralsight.finance.interfaces.Valuable;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Valuable> assests = new ArrayList<>();

    public Portfolio(String name, String owner)
    {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Valuable> getAssests() {
        return assests;
    }

    public void setAssests(List<Valuable> assests) {
        this.assests = assests;
    }

    public void add(Valuable asset)
    {
        assests.add(asset);
    }

    public double getValue()
    {
        double value = 0;
        for (Valuable asset : assests)
        {
            value += asset.getValue();
        }
        return value;
    }

    public Valuable getMostValuable()
    {
        double mostValuable = 0;
        for (Valuable asset : assests)
        {
            mostValuable = Math.max(mostValuable, asset.getValue());
        }

        Valuable mostValuableAsset = null;
        for (Valuable asset : assests)
        {
            if (asset.getValue() == mostValuable)
            {
                mostValuableAsset = asset;
            }
        }

        return mostValuableAsset;
    }

    public Valuable getLeastValuable()
    {
        double leastValuable = Double.POSITIVE_INFINITY;
        for (Valuable asset : assests)
        {
            leastValuable = Math.min(leastValuable, asset.getValue());
        }

        Valuable leastValuableAsset = null;
        for (Valuable asset : assests)
        {
            if (asset.getValue() == leastValuable)
            {
                leastValuableAsset = asset;
            }
        }

        return leastValuableAsset;
    }

}
