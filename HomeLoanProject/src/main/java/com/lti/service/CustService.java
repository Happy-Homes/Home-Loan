package com.lti.service;

import com.lti.entity.Customer;

public interface CustService {
	

	Customer findCustById(int custId);

	Customer login(String email, String password);
	   
    void register(Customer customer);
    
    void update(Customer customer);
    
    Customer updateAUser(Customer customer);
    
    
}
