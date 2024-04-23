package com.pluralsight;

public class Product {
    private String sku;
    private String name;
    private double price;
    private String deparment;

    public Product(String sku, String name, double price, String deparment){
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.deparment = deparment;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDeparment() {
        return deparment;
    }
}
