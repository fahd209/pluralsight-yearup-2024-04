package com.pluralsight.finance;

import com.pluralsight.finance.interfaces.Valuable;

public abstract class FixedAsset implements Valuable {
    private String name;
    private double marketValue;

    public FixedAsset(String name, double value)
    {
        this.name = name;
        this.marketValue = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public double getValue()
    {
        return 0;
    }
}
