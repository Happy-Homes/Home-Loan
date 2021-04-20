package com.lti.service;

import java.util.List;

import com.lti.entity.LoanApplication;

public interface LoanApplicationService {
	
	LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId);
	LoanApplication findLoanById(int loanId);
	List<LoanApplication> viewAllLoanApplications();

}
