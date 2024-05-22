package com.pluralsight.finance;

public class Gold extends FixedAsset {
    private double weight;

    public Gold(String name, double marketValue, double weight) {
        super(name, marketValue);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getValue()
    {
        return getWeight() * getMarketValue();
    }

    public String toString()
    {
        return String.format(" name: %s | value: %.2f ",getName(), getValue());
    }
}
