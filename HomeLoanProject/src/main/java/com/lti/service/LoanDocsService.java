package com.lti.service;

import com.lti.entity.LoanDocument;

public interface LoanDocsService {
	
	LoanDocument getDocs(int docId);
	
	LoanDocument updateDocs(LoanDocument loanDocument);

}
