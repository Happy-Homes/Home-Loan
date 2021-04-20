package com.lti.service;

import com.lti.entity.Admin;


public interface AdminService {
	Admin adminLogin(String adminEmail, String adminPassword);
	void save(Admin admin);
	
}
