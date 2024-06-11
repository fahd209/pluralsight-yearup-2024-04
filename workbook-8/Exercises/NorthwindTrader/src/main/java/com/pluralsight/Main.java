package com.pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        int choice = 3;
        while (choice != 0)
        {
            System.out.println();
            System.out.println("[1] - Display all products");
            System.out.println("[2] - Display all customers");
            System.out.println("[3] - Display all categories");
            System.out.println("[0] - Exit");
            System.out.print("Enter input: ");
            choice = Integer.parseInt(userInput.nextLine());
            switch (choice)
            {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayAllCustomer();
                    break;
                case 3:
                    displayAllCategories();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Good bye :) ");
                    break;
                default:
                    System.out.println("Wrong input :( ");
                    break;
            }
        }
    }

    public static void displayProducts()
    {
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
                        , UnitsInStock
                    FROM products;
                    """;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println();
            System.out.println(" id    name                                                price                           stock           ");
            System.out.println("-".repeat(100));
            while (resultSet.next())
            {
                int productId = resultSet.getInt("ProductId");
                String productName = resultSet.getString("ProductName");
                double price = resultSet.getDouble("UnitPrice");
                int stock = resultSet.getInt("UnitsInStock");
                System.out.printf(" %-5s %-50s  $%-30s %-40s \n", productId, productName, price, stock);
            }
            connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void displayAllCustomer()
    {
        String username = "root";
        String password = "YUm15510n";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", username, password);

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

            System.out.println();
            System.out.println("Contact name                             Company name                             City                                     Country                                  Phone");
            System.out.println("-".repeat(185));
            while(row.next())
            {
                String contactName = row.getString("ContactName");
                String companyName = row.getString("CompanyName");
                String city = row.getString("City");
                String country = row.getString("Country");
                String Phone = row.getString("Phone");

                System.out.printf("%-40s %-40s %-40s %-40s %-40s \n", contactName, companyName, city, country, Phone);
            }

            connection.close();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void displayAllCategories()
    {
        String username = "root";
        String password = "YUm15510n";

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind" ,username, password);

            String sql = """
                    SELECT CategoryId
                        , CategoryName
                    FROM categories;
                    """;

            Statement statement = connection.createStatement();
            ResultSet row = statement.executeQuery(sql);

            System.out.println();
            System.out.println("Category id          Category name");
            System.out.println("-".repeat(40));
            while(row.next())
            {
                int categoryId = row.getInt("CategoryId");
                String categoryName = row.getString("CategoryName");

                System.out.printf("%-20s %-20s \n", categoryId, categoryName);
            }

            System.out.print("Enter your category id: ");
            int id = Integer.parseInt(userInput.nextLine());

            String getProductStatement = """
                    SELECT ProductId
                        , ProductName
                        , UnitPrice
                        , UnitsInStock
                    FROM products
                    WHERE CategoryId = ? ;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(getProductStatement);
            preparedStatement.setInt(1, id);
            ResultSet productRow = preparedStatement.executeQuery();

            System.out.println();
            System.out.println(" id    name                                                price                           stock           ");
            System.out.println("-".repeat(100));
            while (productRow.next())
            {
                int productId = productRow.getInt("ProductId");
                String productName = productRow.getString("ProductName");
                double price = productRow.getDouble("UnitPrice");
                int stock = productRow.getInt("UnitsInStock");
                System.out.printf(" %-5s %-50s $%-30s %-40s \n", productId, productName, price, stock);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}