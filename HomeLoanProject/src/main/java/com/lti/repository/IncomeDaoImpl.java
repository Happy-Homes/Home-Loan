package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.IncomeDetails;
@Repository
public class IncomeDaoImpl implements IncomeDao{
	@PersistenceContext
	EntityManager em;
	
	@Transactional
    public IncomeDetails addOrUpdateIncome(IncomeDetails incomeDetails) {
        return em.merge(incomeDetails);
    }
public IncomeDetails findIncomeById(int incId){
	return em.find(IncomeDetails.class, incId);
}

}
