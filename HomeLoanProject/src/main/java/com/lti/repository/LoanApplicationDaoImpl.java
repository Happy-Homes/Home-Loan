package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.LoanApplication;

@Repository
public class LoanApplicationDaoImpl implements LoanApplicationDao {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId) {

		em.merge(loanApplication);

		return (loanApplication);
	}

	public LoanApplication findLoanById(int loanId) {
		return em.find(LoanApplication.class, loanId);
	}
	
	public List<LoanApplication> viewAllLoanApplications(){
		String jpql="select l from LoanApplication l";
		TypedQuery<LoanApplication> query=em.createQuery(jpql,LoanApplication.class);
		return null;
	}

}