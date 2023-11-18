package com.service;

import java.util.List;

import com.model.Policy;
import com.model.PolicyHolder;
import com.repository.PolicyHolderRepository;

public class PhService {

	private PolicyHolderRepository phRepository=new PolicyHolderRepository();
	public void insertUser(PolicyHolder policyHolder) {

		phRepository.insertUser(policyHolder);
	}

	public boolean doLogin(String userName, String password) {

		return phRepository.doLogin(userName, password);
	}
	public List<Policy> fetchAllProducts() {

		return phRepository.fetchAllProducts();
	}
}
