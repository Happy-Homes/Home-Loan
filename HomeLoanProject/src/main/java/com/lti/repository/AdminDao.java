package com.lti.repository;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

public interface AdminDao {
	Admin login(String adminEmail, String adminPassword);

	void save(Admin admin);

	int findByEmailAndPassword(String email, String password);

	boolean isAdminPresent(String adminEmail);

	Admin findAdminById(int id);

}
