package com.pluralsight.finance;

import com.pluralsight.finance.interfaces.Valuable;

public abstract class FixedAsset implements Valuable {
    private String name;
    private double marketValue;

    public FixedAsset(String name, double value)
    {
        this.name = name;
        this.marketValue = getValue();
    }

    @Override
    public double getValue()
    {
        return 0;
    }
}
