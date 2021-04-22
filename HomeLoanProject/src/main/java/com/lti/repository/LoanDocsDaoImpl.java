package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.LoanDocument;

@Repository
public class LoanDocsDaoImpl implements LoanDocsDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public  LoanDocument findDocsById(int docId) {
		return entityManager.find(LoanDocument.class, docId);
	}
	
	@Transactional
	public LoanDocument addOrUpdateDocs(LoanDocument loanDocument) {
		return entityManager.merge(loanDocument);
	}

	@Override
	public LoanDocument findDocByCustId(int custId) {
		return entityManager.find(LoanDocument.class, custId);
	}

	@Override
	public void save(LoanDocument loanDocument) {
		entityManager.merge(loanDocument);
		
	}

}
