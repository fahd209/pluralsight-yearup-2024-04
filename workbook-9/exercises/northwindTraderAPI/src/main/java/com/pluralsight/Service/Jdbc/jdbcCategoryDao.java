package com.pluralsight.Service.Jdbc;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;
import com.pluralsight.Service.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    public Category addCategory(Category category)
    {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    INSERT INTO categories
                    (CategoryName)
                    VALUES
                    (?);
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.executeUpdate();

            ResultSet row = preparedStatement.getGeneratedKeys();
            row.next();

            int newId = row.getInt(1);
            return getById(newId);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return null;
    }

    @Override
    public void updateCategory(int categoryId, Category category) {

        try(Connection connection = dataSource.getConnection()) {
            String sql = """
                    UPDATE categories
                    SET CategoryName = ?
                    WHERE CategoryId = ?;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setInt(2, categoryId);

            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    DELETE FROM categories
                    WHERE CategoryId = ?;
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);

            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Category createCategory(ResultSet row) throws SQLException {
        int id = row.getInt("CategoryId");
        String name = row.getString("CategoryName");

        return new Category(id, name);
    }
}
