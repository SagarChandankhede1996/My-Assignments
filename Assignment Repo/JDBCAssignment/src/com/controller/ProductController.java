package com.controller;

import java.util.List;
import java.util.Scanner;

import com.models.Product;
import com.myException.InvalidIdException;
import com.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductService productService = new ProductService();
		while (true) {
			System.out.println("\n=====================Model DB Ops======================");
			System.out.println("1. Insert Model");
			System.out.println("2. Fetch All Model");
			System.out.println("3. Fetch Model by Id");
			System.out.println("4. Delete Model by Id");
			System.out.println("5. Find Product by Catogory");
			System.out.println("0. to Exit");
			System.out.println("============================================================");

			int input = sc.nextInt();// 1 2 3 4 5 0
			if (input == 0) {
				System.out.println("Exiting Model, Have a good day!...");
				break;// Exiting while loop
			}
			switch (input) {
			case 1:
				Product model = new Product();
				System.out.println("Enter the Name");
				model.setName(sc.next());

				System.out.println("Enter the Price");
				model.setPrice(sc.nextDouble());

				System.out.println("Enter the Catogory");
				model.setCategory(sc.next());
				productService.insertModel(model);
				System.out.println("New Model Inserted in DB");
				break;
			case 2:
				List<Product> list = productService.fetchAllProducts();
				list.stream().forEach(m -> System.out.println(m));
				break;
			case 3:
				System.out.println("Enter Model Id");
				int id = sc.nextInt();
				try {
					model = productService.getOneModelById(id);
					System.out.println(model);
				} catch (InvalidIdException e1) {
					System.out.println(e1.getMessage());
				}

				break;
			case 4:
				System.out.println("Enter Model Id");
				id = sc.nextInt();
				try {
					productService.deleteModel(id);
					;
					System.out.println("Model Deleted");
				} catch (InvalidIdException e1) {
					System.out.println(e1.getMessage());
				}

				break;

			case 5:
				System.out.println("Enter the Catogory to filter the records");
				String catogory = sc.next();
				list = productService.findProductByCatogory(catogory);
				if (list.size() == 0) {
					System.out.println("Catogory does not exist in DB");
				}
				list.stream().forEach(m -> System.out.println(m));
				break;
			default:
				System.out.println("Invalid Input, Try Again!");
				break;
			}
		}
		sc.close();

	}

}
