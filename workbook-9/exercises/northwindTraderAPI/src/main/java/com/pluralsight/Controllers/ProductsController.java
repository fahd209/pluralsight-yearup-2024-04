package com.pluralsight.Controllers;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;
import com.pluralsight.Service.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product)
    {
        return productDao.addProduct(product);
    }

    @PutMapping("/products/{productId}")
    public void updateProduct(@PathVariable int productId, @RequestBody Product product)
    {
        productDao.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId)
    {
        productDao.deleteProduct(productId);
    }

}
