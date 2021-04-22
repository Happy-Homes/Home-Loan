package com.lti.service;

import com.lti.entity.LoanDocument;

public interface LoanDocsService {
	
	LoanDocument getDocs(int custId);
	void update(LoanDocument loanDocument);
	LoanDocument updateDocs(LoanDocument loanDocument);

}
