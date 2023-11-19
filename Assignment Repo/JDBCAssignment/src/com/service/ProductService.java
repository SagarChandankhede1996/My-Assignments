package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.models.Product;
import com.myException.InvalidIdException;
import com.repository.ProductRepository;

public class ProductService {
	ProductRepository productRepository = new ProductRepository();

	public void insertModel(Product model) {
		productRepository.insertModel(model);
	}

	public List<Product> fetchAllProducts() {

		return productRepository.fetchAllProducts();
	}

	public Product getOneModelById(int id) throws InvalidIdException {
		Product model = productRepository.getOneModelById(id);
		if (model.getId() == 0) {
			throw new InvalidIdException("Invalid ID, please Try Again!!");
		}

		return model;
	}

	public void deleteModel(int id) throws InvalidIdException {
		getOneModelById(id);
		productRepository.deleteModel(id);

	}

	public List<Product> findProductByCatogory(String catogory) {
		List<Product> list = fetchAllProducts();
		list = list.stream().filter(m -> m.getCategory().equalsIgnoreCase(catogory)).collect(Collectors.toList());
		return list;
	}

}
