package com.pluralsight.services;

import com.pluralsight.models.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class MySqlCustomers implements customersDao{
    DataSource dataSource;

    public MySqlCustomers(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAllCustomers() {
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
