package com.lti.repository;

import com.lti.entity.LoanDocument;

public interface LoanDocsDao {
	
	LoanDocument findDocsById(int docId);
	LoanDocument findDocByCustId(int custId);
	void save(LoanDocument loanDocument);
	
	LoanDocument addOrUpdateDocs(LoanDocument loanDocument);
	
}
