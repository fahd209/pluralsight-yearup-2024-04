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

    public Product createProduct(ResultSet row) throws SQLException {
        int id = row.getInt("ProductId");
        String productName = row.getString("ProductName");
        int categoryId = row.getInt("CategoryId");
        double unitPrice = row.getDouble("UnitPrice");

        return new Product(id, productName, categoryId, unitPrice);
    }
}
