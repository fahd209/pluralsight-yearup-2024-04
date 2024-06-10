package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String username = "root";
        String password = "YUm15510n";

        try
        {
            //Class.forName("com.mysql.cl.jdbc.Driver");
            //1. connect to database
            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",username, password);

            // 2. execute statement
            String sql = """
                    SELECT ProductId
                        , ProductName
                        , UnitPrice
                    FROM products;
                    """;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                int productId = resultSet.getInt("ProductId");
                String productName = resultSet.getString("ProductName");
                double price = resultSet.getDouble("UnitPrice");

                System.out.println(productId + " | " + productName + " | " + price);
            }

            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}