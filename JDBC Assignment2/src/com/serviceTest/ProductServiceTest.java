package com.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.models.Product;

import com.myException.InvalidInputException;
import com.service.ProductService;

public class ProductServiceTest {

	ProductService productService = new ProductService();

	@Test
	public void testIncreasePriceByCategory() {

		ProductService productService = new ProductService();
		// use case 1 for valid catogory
		try {
			Product product = new Product(1, "Mobile", 100d, "Mobiles");
			assertEquals(102d, productService.increasePriceByCategory(product).getPrice(), 0.001);
		} catch (InvalidInputException e) {
		}

		try {
			Product product = new Product(2, "Laptop", 200d, "Laptops");
			assertEquals(202d, productService.increasePriceByCategory(product).getPrice(), 0.001);
		} catch (InvalidInputException e) {
		}

		// use case 2 : for Invalid catogory

		try {
			Product product = new Product(2, "Laptop", 100, "charger");
			assertEquals(2d, productService.increasePriceByCategory(product).getPrice(), 0.001);
		} catch (InvalidInputException e) {
			assertEquals("Category does not exist!".toLowerCase(), e.getMessage().toLowerCase());
		}
		// use case 3 : Invalid input blank
		try {
			Product product = new Product(2, "Laptop", 100, "");
			assertEquals(2d, productService.increasePriceByCategory(product).getPrice(), 0.001);
		} catch (InvalidInputException e) {
			assertEquals("Invalid Category!".toLowerCase(), e.getMessage().toLowerCase());
		}
		// use case 4 : Invalid input null
		try {
			Product product = new Product(2, "Laptop", 100, null);
			assertEquals(2d, productService.increasePriceByCategory(product).getPrice(), 0.001);
		} catch (InvalidInputException e) {
			assertEquals("Invalid Category!".toLowerCase(), e.getMessage().toLowerCase());
		}
	}

	@Test
	public void testComputeTotalPrice() {

		// use case 1 : valid price
		try {
			Product[] products = { new Product(1, "Mobile", 100d, "Mobiles"),
					new Product(2, "Laptop", 150d, "Laptops") };
			assertEquals(250d, productService.computeTotalPrice(products), 0.001);
		} catch (InvalidInputException e) {

		}
		// use case 2 : Invalid Price
		try {
			Product[] products = { new Product(1, "Mobile", -100d, "Mobiles"),
					new Product(2, "Laptop", 150d, "Laptops") };
			assertEquals(250d, productService.computeTotalPrice(products), 0.001);
		} catch (InvalidInputException e) {
			assertEquals("Price cannot be Negative or zero".toLowerCase(), e.getMessage().toLowerCase());
		}

	}

	@Test
	public void testComputeGreaterPrice() {
		// use case 1
		try {
			Product p1 = new Product(1, "Mobile", 100, "Mobiles");
			Product p2 = new Product(2, "Laptop", 150, "Laptops");

			assertEquals(p2, productService.computeGreaterPrice(p1, p2));
		} catch (Exception e) {

		}

		// use case 2:for equal price
		try {
			Product p1 = new Product(1, "Mobile", 100, "Mobiles");
			Product p2 = new Product(2, "Laptop", 100, "Laptops");

			assertEquals(p2 = p1, productService.computeGreaterPrice(p1, p2));
		} catch (Exception e) {

		}
	}
}
