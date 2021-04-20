package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.exception.AdminServiceException;
import com.lti.repository.AdminDao;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public void save(Admin admin) {
		adminDao.save(admin);
		
	}

	@Override
	public Admin adminLogin(String adminEmail, String adminPassword) {
		try {
            if(!adminDao.isAdminPresent(adminEmail))
                throw new AdminServiceException("Customer not registered!");
            int id = adminDao.findByEmailAndPassword(adminEmail, adminPassword);
            Admin admin = adminDao.findAdminById(id);
            return admin;
        }
        catch(EmptyResultDataAccessException e) {
            throw new AdminServiceException("Incorrect email/password");
        }
    
	}

}
