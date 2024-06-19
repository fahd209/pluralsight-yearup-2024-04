package com.pluralsight.Controllers;

import com.pluralsight.Model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    @GetMapping("/categories")
    public List<Category> getAllCategories()
    {
        return List.of(
                new Category(1, "drinks")
        );
    }
}
