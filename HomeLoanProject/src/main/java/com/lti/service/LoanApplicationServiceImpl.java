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
	
	public LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId,int incomeId,int propertyId) {
		LoanApplication application =  loanApplicationDao.addOrUpdateLoanApplication(loanApplication, custId,incomeId,propertyId);
		return application;
	}
	
	public LoanApplication findLoanById(int loanAppNo) {
		LoanApplication application=loanApplicationDao.findLoanById(loanAppNo);
		return application;
	}
	
	public List<LoanApplication> viewAllLoanApplications() {
		return loanApplicationDao.viewAllLoanApplications();
	}

	@Override
	public LoanApplication addOrUpdateLoanIncome(LoanApplication loanApplication, int incomeId) {
		return loanApplicationDao.addOrUpdateLoanIncome(loanApplication,incomeId);
	}

	@Override
	public LoanApplication addOrUpdateLoanProperty(LoanApplication loanApplication, int propertyId) {
		return loanApplicationDao.addOrUpdateLoanProperty(loanApplication,propertyId);
	}
	
	
}
