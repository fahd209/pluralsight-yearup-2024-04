package com.pluralsight.services;

import com.pluralsight.models.Category;

import java.util.List;

public interface categoriesDao {
    List<Category> getAllCategories();
}
