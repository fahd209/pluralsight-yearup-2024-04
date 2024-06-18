package com.pluralsight.Services;

import com.pluralsight.Models.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    List<Product> getAllProducts();
}
