package com.pluralsight.Service;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAll();

    Product getById(int id);

    Product addProduct(Product product);

    void updateProduct(int productId, Product product);

    void deleteProduct(int productId);
}
