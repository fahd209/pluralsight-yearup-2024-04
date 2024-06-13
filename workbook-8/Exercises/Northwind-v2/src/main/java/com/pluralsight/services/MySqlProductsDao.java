package com.pluralsight.services;

import com.pluralsight.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class MySqlProductsDao implements productsDao{
    DataSource dataSource;

    public MySqlProductsDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> displayAllProducts() {
        try(Connection connection = dataSource.getConnection())
        {

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return List.of();
    }

    @Override
    public Product displayProductByCategoryId(int categoryId) {
        try(Connection connection = dataSource.getConnection())
        {

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
