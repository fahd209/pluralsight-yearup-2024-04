package com.pluralsight.Controllers;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return List.of(
                new Product(1, "soda", 1, 25),
                new Product(2, "juice", 1, 12)
        );
    }

    @GetMapping("/products/{id}")
    public List<Product> getProductById(int id)
    {
        return List.of(
                new Product(1, "soda", 1, 25),
                new Product(2, "juice", 1, 12)
        );
    }

}
