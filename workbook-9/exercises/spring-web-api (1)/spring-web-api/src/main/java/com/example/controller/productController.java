package com.example.controller;

import com.example.Models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class productController {

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "idk", 3, 20));
        products.add(new Product(2, "phone", 2, 10));

        return products;
    }
}
