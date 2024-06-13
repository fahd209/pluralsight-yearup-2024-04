package com.pluralsight.services;

import com.pluralsight.models.Product;

import java.util.List;

public interface productsDao {
    List<Product> displayAllProducts();

    Product displayProductByCategoryId(int categoryId);
}
