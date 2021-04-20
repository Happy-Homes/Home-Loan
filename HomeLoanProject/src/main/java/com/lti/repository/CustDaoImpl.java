package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class CustDaoImpl implements CustDao {
	
	@PersistenceContext
	EntityManager em;
	

	@Transactional
	public void save(Customer customer) {
		  em.merge(customer);
	}

	public Customer findCustById(int custId) {
		return em.find(Customer.class, custId);
	}
	@Override
    public boolean isCustomerPresent(String email) {
        return (Long)
                em
                .createQuery("select count(c.custId) from Customer c where c.custEmail = :em")
                .setParameter("em", email)
                .getSingleResult() == 1 ? true : false;
    }
   
    @Override
    public int findByEmailAndPassword(String email, String password) {
        return (Integer) em
                .createQuery("select c.custId from Customer c where c.custEmail = :em and c.custPassword = :pw")
                .setParameter("em", email)
                .setParameter("pw", password)
                .getSingleResult();
    }



	@Transactional
	public Customer updateAUser(Customer customer) {
		Customer cust = em.merge(customer);
		return cust;
	}

	
	
	
	
}

