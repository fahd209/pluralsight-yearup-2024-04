package com.pluralsight;

import com.pluralsight.Models.Product;
import com.pluralsight.Services.ProductDao;
import com.pluralsight.Services.SimpleProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTraderSpringbootApplication {
	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");
		SpringApplication.run(NorthwindTraderSpringbootApplication.class, args);

		ProductDao productDao = context.getBean(SimpleProductDao.class);

		int choice = 3;
		while (choice != 0) {
			System.out.println("1. List Employees");
			System.out.println("2. add Employees");
			System.out.print("Input: ");
			choice = userInput.nextInt();
			userInput.nextLine();

			switch (choice) {
				case 1:
					displayProducts(productDao);
					break;
				case 2:
					addProduct(productDao        );
					break;
				case 0:
					System.out.println("Good bye");
					break;
				default:
					System.out.println("Wrong input");
			}
		}
	}


	public static void displayProducts(ProductDao productDao)
	{
		List<Product> productList = productDao.getAllProducts();

		productList.forEach(product -> System.out.println(product.toString()));
	}

	public static void addProduct(ProductDao productDao)
	{
		System.out.print("Enter product id: ");
		int id = userInput.nextInt();
		userInput.nextLine();
		System.out.print("Enter product name: ");
		String name = userInput.nextLine();
		System.out.print("Enter category name: ");
		String category = userInput.nextLine();
		System.out.print("Enter price: ");
		double price = userInput.nextDouble();
		userInput.nextLine();

		Product product = new Product(id, name, category, price);
		productDao.addProduct(product);
	}
}
