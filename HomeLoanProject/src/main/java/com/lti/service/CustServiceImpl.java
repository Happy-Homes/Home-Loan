package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;
import com.lti.repository.CustDao;

@Service
public class CustServiceImpl implements CustService {
	
	@Autowired
	CustDao custDao;
	
	@Autowired
	EmailService emailService;
	

	@Override
	public Customer findCustById(int custId) {
		
		return custDao.findCustById(custId);
	}
	
	@Override
    public Customer login(String email, String password) {
        try {
            if(!custDao.isCustomerPresent(email))
                throw new CustomerServiceException("Customer not registered!");
            int id = custDao.findByEmailAndPassword(email, password);
            Customer customer = custDao.findCustById(id);
            return customer;
        }
        catch(EmptyResultDataAccessException e) {
            throw new CustomerServiceException("Incorrect email/password");
        }
    }

	@Override
	public void register(Customer customer) {
		if(!custDao.isCustomerPresent(customer.getCustEmail())) {
            custDao.save(customer);
            String subject="Registration Confirmation";
            String text="Hi "+customer.getCustName()+" Welcome to HappyHomes!";
            emailService.sendEmailForNewRegistration(customer.getCustEmail(),text,subject);
        }
        else
            throw new CustomerServiceException("Customer already registered!");
		
	}

	@Override
	public void update(Customer customer) {
		custDao.save(customer);
		
	}

	@Override
	public Customer updateAUser(Customer customer) {
		return custDao.updateAUser(customer);
	}
	
}
