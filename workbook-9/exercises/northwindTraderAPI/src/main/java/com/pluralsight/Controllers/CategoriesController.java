package com.pluralsight.Controllers;

import com.pluralsight.Model.Category;
import com.pluralsight.Service.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class CategoriesController {

    CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao)
    {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories()
    {
        return categoryDao.getAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id)
    {
        return categoryDao.getById(id);
    }
}
