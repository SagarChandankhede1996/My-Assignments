package com.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.models.Product;
import com.service.ProductService2;


public class ProductService2Test {
	ProductService2 service = new ProductService2();
	Product p1 = new Product(1,"Iphone 13",2000,"mobiles");
	Product p2 = new Product(2,"Dell Lalitude",3000,"laptop");
	@Test
	public void increasePriceByCategoryTest() {
		assertEquals(2040,Math.round(service.increasePriceByCategory(p1).getPrice()));

	}
	@Test
	public void computeTotalPrice() {
		Product[] parry = {p1,p2};
		assertEquals(5000,Math.round(service.computeTotalPrice(parry)));
	}
	@Test
	public void computeGreaterPrice() {
		assertEquals(3000,Math.round(service.computeGreaterPrice(p1, p2)));
	}
}
