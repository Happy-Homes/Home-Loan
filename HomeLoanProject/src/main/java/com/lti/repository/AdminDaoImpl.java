package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
@Repository
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	EntityManager em;
	@Transactional
	public void save(Admin admin) {
		em.merge(admin);
		
	}
	@Override
    public int findByEmailAndPassword(String adminEmail, String adminPassword) {
        return (Integer) em
                .createQuery("select a.adminId from Admin a where a.adminEmail = :em and a.adminPassword = :pw")
                .setParameter("em", adminEmail)
                .setParameter("pw", adminPassword)
                .getSingleResult();
    }
	@Override
	public Admin login(String adminEmail, String adminPassword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAdminPresent(String adminEmail) {
		return (Long)
                em
                .createQuery("select count(a.adminId) from Admin a where a.adminEmail = :em")
                .setParameter("em", adminEmail)
                .getSingleResult() == 1 ? true : false;
	}
	@Override
	public Admin findAdminById(int adminId) {
		return em.find(Admin.class, adminId);
	}
	
}
