package com.pluralsight.Controllers;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;
import com.pluralsight.Service.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {
    ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao)
    {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productDao.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id)
    {
        return productDao.getById(id);
    }

}
