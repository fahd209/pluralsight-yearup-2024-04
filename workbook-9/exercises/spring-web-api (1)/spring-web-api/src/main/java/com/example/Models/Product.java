package com.example.Models;

public class Product {
    private int productId;
    private String productName;
    private int unitsInStock;
    private double unitPrice;

    public Product(int productId, String productName, int unitsInStock, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.unitsInStock = unitsInStock;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
