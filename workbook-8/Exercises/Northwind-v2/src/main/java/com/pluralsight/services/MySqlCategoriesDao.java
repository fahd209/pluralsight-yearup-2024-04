package com.pluralsight.services;

import com.pluralsight.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoriesDao implements categoriesDao{
    DataSource dataSource;

    public MySqlCategoriesDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAllCategories() {

        List<Category> categoryList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT CategoryId
                        , CategoryName
                    FROM categories;
                    """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while(row.next())
            {
                int categoryId = row.getInt("CategoryId");
                String categoryName = row.getString("CategoryName");

                Category category = new Category(categoryId, categoryName);
                categoryList.add(category);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return categoryList;
    }
}
