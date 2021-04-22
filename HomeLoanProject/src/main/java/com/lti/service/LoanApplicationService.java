package com.lti.service;

import java.util.List;

import com.lti.entity.LoanApplication;

public interface LoanApplicationService {
	
	LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId,int incomeId,int propertyId);
	LoanApplication findLoanById(int loanAppNo);
	List<LoanApplication> viewAllLoanApplications();
	LoanApplication addOrUpdateLoanIncome(LoanApplication loanApplication,int incomeId);
	LoanApplication addOrUpdateLoanProperty(LoanApplication loanApplication,int propertyId);
}
