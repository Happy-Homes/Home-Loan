package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.LoanApplication;
import com.lti.repository.LoanApplicationDao;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

	@Autowired
	LoanApplicationDao loanApplicationDao;
	
	public LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId) {
		return loanApplicationDao.addOrUpdateLoanApplication(loanApplication, custId);
	}
	
	public LoanApplication findLoanById(int loanId) {
		return loanApplicationDao.findLoanById(loanId);
	}
	
	public List<LoanApplication> viewAllLoanApplications() {
		return loanApplicationDao.viewAllLoanApplications();
	}
	
}
