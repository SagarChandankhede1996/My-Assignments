package com.service;

import java.util.List;

import com.model.Buy;
import com.model.Policy;
import com.model.PolicyDetails;
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
	public List<Policy> fetchAllPolicies() {

		return phRepository.fetchAllPolicies();
	}

	public PolicyDetails fetchPolicyDetails(int id) {
		// TODO Auto-generated method stub
		return phRepository.fetchPolicyDetails(id);
	}
	public void buyPolicy(Buy buy) {
		phRepository.buyPolicy(buy);
	}
	public Buy fetchUserId(String username) {
		return phRepository.fetchUserId(username);
	}
}
