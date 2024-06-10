package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String username = "root";
        String password = "YUm15510n";
        try
        {
            // 1. connect to database
            //Class.forName("com.mysql.cl.jdbc.Driver");
            Connection connection;
            connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/world", username, password
            );

            // 2. execute the statement
            String sql = """
                    SELECT Id
                        , Name
                        , CountryCode
                    FROM city
                    WHERE CountryCode = 'USA';
                    """;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 3. read the date in the result set
            while(resultSet.next())
            {
                int id = resultSet.findColumn("Id");
                String name = resultSet.getString("Name");
                String CountryCode = resultSet.getString("CountryCode");

                System.out.println(id + " " + " " + name + " " + CountryCode);
            }

            // 4. close the connection
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}