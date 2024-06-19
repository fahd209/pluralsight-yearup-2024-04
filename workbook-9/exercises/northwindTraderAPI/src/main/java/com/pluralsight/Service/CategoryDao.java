package com.pluralsight.Service;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    Category getById(int id);
}
