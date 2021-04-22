package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;
import com.lti.entity.EmiDetails;
import com.lti.entity.IncomeDetails;
import com.lti.entity.LoanApplication;
import com.lti.entity.Property;

@Repository
public class LoanApplicationDaoImpl implements LoanApplicationDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId,int incomeId,int propertyId) {
		loanApplication.setCustomer(em.find(Customer.class,custId ));
		
		  loanApplication.setIncomeDetails(em.find(IncomeDetails.class, incomeId));
		  loanApplication.setProperty(em.find(Property.class, propertyId));
		 
		
		return em.merge(loanApplication);
	}

	public LoanApplication findLoanById(int loanAppNo) {
		return em.find(LoanApplication.class, loanAppNo);
	}
	
	public List<LoanApplication> viewAllLoanApplications(){
		String jpql="select l from LoanApplication l";
		TypedQuery<LoanApplication> query=em.createQuery(jpql,LoanApplication.class);
		return null;
	}

	@Transactional
	public LoanApplication addOrUpdateLoanIncome(LoanApplication loanApplication, int incomeId) {
		loanApplication.setIncomeDetails(em.find(IncomeDetails.class, incomeId));
		em.merge(loanApplication);

		return (loanApplication);
	}

	@Transactional
	public LoanApplication addOrUpdateLoanProperty(LoanApplication loanApplication, int propertyId) {
		loanApplication.setProperty(em.find(Property.class, propertyId));
		em.merge(loanApplication);

		return (loanApplication);
	}
	
	

}