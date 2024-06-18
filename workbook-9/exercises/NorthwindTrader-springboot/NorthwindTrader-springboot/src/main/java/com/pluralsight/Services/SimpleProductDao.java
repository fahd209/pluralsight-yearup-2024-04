package com.pluralsight.Services;

import com.pluralsight.Models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao{

    List<Product> products = new ArrayList<>();

    public SimpleProductDao() {

    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}
