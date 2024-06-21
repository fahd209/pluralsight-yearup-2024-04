package com.pluralsight.Service;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    Category getById(int id);

    Category addCategory(Category category);

    void updateCategory(int categoryId, Category category);

    void deleteCategory(int categoryId);
}
