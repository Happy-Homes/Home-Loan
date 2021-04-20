package com.lti.repository;

import com.lti.entity.LoanDocument;

public interface LoanDocsDao {
	
	LoanDocument findDocsById(int docId);
	
	LoanDocument addOrUpdateDocs(LoanDocument loanDocument);
	
}
