package com.inventory;

import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ProductDAO dao = new ProductDAO();

		while (true) {

			System.out.println("\n===== PRODUCT INVENTORY =====");
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();

			if (choice == 1) {

				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				System.out.print("Enter Name: ");
				String name = sc.next();

				System.out.print("Enter Category: ");
				String category = sc.next();

				System.out.print("Enter Price: ");
				double price = sc.nextDouble();

				System.out.print("Enter Quantity: ");
				int quantity = sc.nextInt();

				Product p = new Product(id, name, category, price, quantity);

				dao.addProduct(p);

			} else if (choice == 2) {

				dao.viewProducts();

			} else if (choice == 3) {

				System.out.print("Enter Product ID: ");
				int id = sc.nextInt();

				System.out.print("Enter New Price: ");
				double price = sc.nextDouble();

				System.out.print("Enter New Quantity: ");
				int quantity = sc.nextInt();

				dao.updateProduct(id, price, quantity);

			} else if (choice == 4) {

				System.out.print("Enter Product ID: ");
				int id = sc.nextInt();

				dao.deleteProduct(id);

			} else if (choice == 5) {

				System.out.println("Program ended");
				break;

			} else {

				System.out.println("Invalid choice");
			}
		}

		sc.close();
	}
}