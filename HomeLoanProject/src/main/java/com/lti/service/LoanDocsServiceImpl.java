package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lti.entity.Customer;
import com.lti.entity.LoanDocument;
import com.lti.repository.LoanDocsDao;

@Service
public class LoanDocsServiceImpl implements LoanDocsService {
	
	@Autowired
	private LoanDocsDao docsDao;
	
	public LoanDocument getDocs(int docId) {
		return docsDao.findDocsById(docId);
	}
	
	public LoanDocument updateDocs(LoanDocument loanDocument) {
		return docsDao.addOrUpdateDocs(loanDocument);
	}
	

}