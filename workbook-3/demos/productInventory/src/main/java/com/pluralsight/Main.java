package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args)
    {
        loadProducts();

        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getName() + " | " + products.get(i).getPrice());
        }

    }

    public static void loadProducts()
    {

        File file = new File("files/products.csv");

        try(Scanner fileScanner = new Scanner(file))
        {
            fileScanner.nextLine();

            while (fileScanner.hasNext())
            {

                String line = fileScanner.nextLine();
                String[] columns = line.split("[|]");

                String sku = columns[0];
                String name = columns[1];
                double price = Double.parseDouble(columns[2]);
                String deparment = columns[3];

                Product product = new Product(sku, name, price, deparment);

                products.add(product);
            }
        }
        catch (IOException ex)
        {
            System.out.println("File does not exist");
        }
    }
}