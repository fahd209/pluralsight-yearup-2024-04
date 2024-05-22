package com.pluralsight.finance;

public class Jewelry extends FixedAsset{
    private double karat;

    public Jewelry(String name, double valuePerKarat, double karat)
    {
        super(name, valuePerKarat);
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }

    public void setKarat(double karat) {
        this.karat = karat;
    }

    @Override
    public double getValue() {
        return getKarat() * getMarketValue();
    }

    public String toString()
    {
        return String.format(" name: %s, value: %.2f , karats: %.2f", getName(), getValue(), getKarat());
    }
}
