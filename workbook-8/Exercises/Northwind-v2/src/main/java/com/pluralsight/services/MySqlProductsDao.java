package com.pluralsight.services;

import com.pluralsight.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductsDao implements productsDao{
    DataSource dataSource;

    public MySqlProductsDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> productsList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection())
        {
            String sql =
                    """
                    SELECT ProductId
                        , ProductName
                        , UnitPrice
                        , UnitsInStock
                    FROM products;
                    """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while (row.next())
            {
                int id = row.getInt("ProductId");
                String productName = row.getString("ProductName");
                double unitPrice = row.getDouble("UnitPrice");
                int unitsInStock = row.getInt("UnitsInStock");

                Product product = new Product(id, productName, unitPrice, unitsInStock);
                productsList.add(product);
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return productsList;
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {

        List<Product> productsByCategoryId = new ArrayList<>();
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT ProductId
                        , ProductName
                        , UnitPrice
                        , UnitsInStock
                    FROM products
                    WHERE CategoryId = ?;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryId);
            ResultSet row = preparedStatement.executeQuery();

            while(row.next())
            {
                int id = row.getInt("ProductId");
                String productName = row.getString("ProductName");
                double unitPrice = row.getDouble("UnitPrice");
                int unitsInStock = row.getInt("UnitsInStock");

                Product product = new Product(id, productName, unitPrice, unitsInStock);
                productsByCategoryId.add(product);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return productsByCategoryId;
    }
}
