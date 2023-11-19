package com.service;

import java.util.*;
import com.models.Product;
import com.myException.InvalidInputException;

public class ProductService {

	public Product increasePriceByCategory(Product p) throws InvalidInputException {
		List<String> categoryList = Arrays.asList("Mobiles", "Laptops");
		if (p.getCategory() == null || p.getCategory().equals("")) {
			throw new InvalidInputException("Invalid Category!");
		}
		if (!categoryList.contains(p.getCategory())) {
			throw new InvalidInputException("Category does not exist!");
		}
		if ("Mobiles".equals(p.getCategory())) {
			p.setPrice(p.getPrice() * 1.02);
		} else if ("Laptops".equals(p.getCategory())) {
			p.setPrice(p.getPrice() * 1.01);
		}
		return p;
	}

	public double computeTotalPrice(Product[] products) throws InvalidInputException {

		for (Product product : products) {

			if (product.getPrice() <= 0) {
				throw new InvalidInputException("Price cannot be Negative or zero");
			}

		}
		double totalPrice = 0;
		for (Product product : products) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}

	public Product computeGreaterPrice(Product p1, Product p2) {
//throw the exception if its void
		if (p1.getPrice() > p2.getPrice()) {
			return p1;
		} else if (p1.getPrice() < p2.getPrice()) {
			return p2;
		} 
		return p1=p2;
	}

}
