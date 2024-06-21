package com.pluralsight.Service.Jdbc;

import com.pluralsight.Model.Category;
import com.pluralsight.Model.Product;
import com.pluralsight.Service.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcProductDao implements ProductDao {
    DataSource dataSource;

    @Autowired
    public jdbcProductDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> allProducts = new ArrayList<>();
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT ProductId
                        , ProductName
                        , CategoryId
                        , UnitPrice
                    FROM products;
                    """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while (row.next())
            {
                Product product = createProduct(row);
                allProducts.add(product);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return allProducts;
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT ProductId
                        , ProductName
                        , CategoryId
                        , UnitPrice
                    FROM products
                    WHERE ProductId = ?;
                    """;

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet row = statement.executeQuery();

            if(row.next())
            {
                product = createProduct(row);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return product;
    }

    @Override
    public Product addProduct(Product product) {
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    INSERT INTO products
                    (ProductName, CategoryId, UnitPrice)
                    VALUES
                    (?, ?, ?)
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setDouble(3, product.getUnitPrice());
            preparedStatement.executeUpdate();

            ResultSet row = preparedStatement.getGeneratedKeys();
            row.next();

            int newId = row.getInt(1);

            return getById(newId);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void updateProduct(int productId, Product product) {

        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    UPDATE products
                    SET productName = ?
                        , categoryId = ?
                        , UnitPrice = ?
                    WHERE productId = ?;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setDouble(3, product.getUnitPrice());
            preparedStatement.setDouble(4, productId);
            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try(Connection connection = dataSource.getConnection()) {
            String sql = """
                    DELETE FROM products
                    WHERE productId = ?;
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public Product createProduct(ResultSet row) throws SQLException {
        int id = row.getInt("ProductId");
        String productName = row.getString("ProductName");
        int categoryId = row.getInt("CategoryId");
        double unitPrice = row.getDouble("UnitPrice");

        return new Product(id, productName, categoryId, unitPrice);
    }
}
