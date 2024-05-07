package com.pluralsight;

import com.pluralsight.io.ProductLoader;
import com.pluralsight.models.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class HardWareStore {
    private static Scanner userInput = new Scanner(System.in);
    private ProductLoader productLoader = new ProductLoader();
    ArrayList<Product> products;

    public HardWareStore()
    {
        products = productLoader.loadProducts();
    }

    public void run()
    {
        System.out.println("yay");

        while (true)
        {
            int choice = disPlayHomeChoices();
            switch (choice){
                case 1:
                    findProductById();
                    break;
                case 2:
                    findProductByCategory();
                    break;
                case 3:
                    return;
            }

        }
    }

    public  int disPlayHomeChoices()
    {
        System.out.println();
        System.out.println("Fahd's hardware Store");
        System.out.println("-------------------------");
        System.out.println("1) Find product by ID");
        System.out.println("2) Search by category");
        System.out.println("3) Exit");
        int choice = userInput.nextInt();
        return choice;
    }

    public void findProductById()
    {
        System.out.println();
        System.out.println("Find product by ID");
        System.out.println("-".repeat(30));
        System.out.println("Enter product id: ");
        int productId = userInput.nextInt();

        Product product = null;

        for (Product currentProduct : products)
        {
            product = currentProduct;
        }

        System.out.println("Id: " + product.getId());
        System.out.println("Category: " + product.getCategory());
        System.out.println();
    }

    public void findProductByCategory()
    {

    }
}
