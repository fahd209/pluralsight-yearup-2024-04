package com.pluralsight.services;

import com.pluralsight.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class MySqlCategoriesDao implements categoriesDao{
    DataSource dataSource;

    public MySqlCategoriesDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {
        try(Connection connection = dataSource.getConnection())
        {

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return List.of();
    }
}
