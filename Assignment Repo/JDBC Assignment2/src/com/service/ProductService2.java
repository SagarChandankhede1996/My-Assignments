package com.service;

import com.models.Product;

public class ProductService2 {

	public Product increasePriceByCategory(Product p) {
		switch(p.getCategory()) {
		case "mobiles":
			p.setPrice(p.getPrice()*1.02);
			break;
		case "laptops":
			p.setPrice(p.getPrice()*1.01);
			break;
		}
		return p;
	}
	
	public double computeTotalPrice(Product[] parry) {
		double sum = 0;
		for(Product p : parry) {
			sum = sum + p.getPrice();
		}
		return sum;
	}
	
	public double computeGreaterPrice(Product p1,Product p2)
	{

		if(p1.getPrice() > p2.getPrice())
			return p1.getPrice();
		return p2.getPrice();
	}
}
