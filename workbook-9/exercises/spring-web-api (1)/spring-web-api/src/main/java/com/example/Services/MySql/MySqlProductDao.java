package com.example.Services.MySql;

import com.example.Models.Product;
import com.example.Services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

public class MySqlProductDao implements ProductDao {
    DataSource dataSource;

    @Autowired
    public MySqlProductDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
