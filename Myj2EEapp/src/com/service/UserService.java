package com.service;
import java.util.List;

import com.models.Products;
import com.models.Users;
import com.repository.UserRepository;


public class UserService {

	private UserRepository userRepository=new UserRepository();
	
	public void insertUser(Users user) {
		
		userRepository.insertUser(user);
	}

	public boolean doLogin(String userName, String password) {
		
		return userRepository.doLogin(userName, password);
	}

	public List<Products> fetchAllProducts() {
		
		return userRepository.fetchAllProducts();
	}

}
