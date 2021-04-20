package com.lti.repository;

import com.lti.entity.Customer;

public interface CustDao {
	void save(Customer customer);

	Customer findCustById(int custId);

	int findByEmailAndPassword(String email, String password);

	boolean isCustomerPresent(String email);
	
	Customer updateAUser(Customer customer);
}
