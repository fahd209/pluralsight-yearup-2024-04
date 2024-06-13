package com.pluralsight.application;

import com.pluralsight.services.MySqlCategoriesDao;
import com.pluralsight.services.MySqlCustomers;
import com.pluralsight.services.MySqlProductsDao;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class NorthwindApplication {

    DataSource dataSource = null;
    MySqlCustomers customersSql;
    MySqlCategoriesDao categoriesSql;
    MySqlProductsDao productsSql;
    Scanner userInput = new Scanner(System.in);

    public NorthwindApplication()
    {
        this.dataSource = buildDataSource();
        customersSql = new MySqlCustomers(dataSource);
        categoriesSql = new MySqlCategoriesDao(dataSource);
        productsSql = new MySqlProductsDao(dataSource);
    }

    private DataSource buildDataSource()
    {
        try(FileInputStream stream = new FileInputStream("src/main/resources/config.properties"))
        {
            Properties properties = new Properties();
            properties.load(stream);

            String connectionString = properties.getProperty("db.connectionString");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(connectionString);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);

            return basicDataSource;
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        return null;
    }

    public void run()
    {
        int choice = Integer.MAX_VALUE;
        while (choice != 0)
        {
            choice = getUserInput();
            switch (choice) {
                case 1 -> displayAllProducts();
                case 2 -> displayAllCustomer();
                case 3 -> displayAllCategories();
                case 0 -> System.exit(0);
            }
        }
    }

    public int getUserInput()
    {
        System.out.println();
        System.out.println("[1] - Display all products");
        System.out.println("[2] - Display all customers");
        System.out.println("[3] - Display all categories");
        System.out.println("[0] - Exit");
        System.out.print("Enter input: ");
        return Integer.parseInt(userInput.nextLine());
    }

    public void displayAllProducts()
    {

    }

    public void displayAllCustomer()
    {

    }

    public void displayAllCategories()
    {

    }
}
