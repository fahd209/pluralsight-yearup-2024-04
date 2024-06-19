package com.pluralsight.Service.Jdbc;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;
import com.pluralsight.Service.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcCategoryDao implements CategoryDao {

    DataSource dataSource;

    @Autowired
    public jdbcCategoryDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {

        List<Category> allCategories = new ArrayList<>();
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT CategoryId
                        , CategoryName
                    FROM categories;
                    """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while (row.next())
            {
                Category category = createCategory(row);
                allCategories.add(category);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return allCategories;
    }

    @Override
    public Category getById(int id) {
        Category category = null;

        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                        SELECT CategoryId
                            , CategoryName
                        FROM categories
                        WHERE CategoryId = ?;
                        """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet row = preparedStatement.executeQuery();

            if(row.next())
            {
                category = createCategory(row);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return category;
    }

    public Category createCategory(ResultSet row) throws SQLException {
        int id = row.getInt("CategoryId");
        String name = row.getString("CategoryName");

        return new Category(id, name);
    }
}
