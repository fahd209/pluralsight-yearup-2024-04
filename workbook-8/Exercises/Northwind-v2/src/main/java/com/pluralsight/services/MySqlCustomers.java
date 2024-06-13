package com.pluralsight.services;

import com.pluralsight.models.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomers implements customersDao{
    DataSource dataSource;

    public MySqlCustomers(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customerList = new ArrayList<>();
        try(Connection connection = dataSource.getConnection())
        {
            String sql = """
                    SELECT ContactName
                    	, CompanyName
                        , City
                        , Country
                        , Phone
                    FROM customers
                    ORDER BY Country;
                    """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            while(row.next())
            {
                String contactName = row.getString("ContactName");
                String companyName = row.getString("CompanyName");
                String city = row.getString("City");
                String country = row.getString("Country");
                String phone = row.getString("Phone");

                Customer customer = new Customer(contactName, companyName, city, country, phone);
                customerList.add(customer);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return customerList;
    }
}
