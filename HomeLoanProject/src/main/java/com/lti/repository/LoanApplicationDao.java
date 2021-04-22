package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.LoanApplication;

public interface LoanApplicationDao {

	LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId,int incomeId,int propertyId);
	LoanApplication addOrUpdateLoanIncome(LoanApplication loanApplication,int incomeId);
	LoanApplication addOrUpdateLoanProperty(LoanApplication loanApplication,int propertyId);
	LoanApplication findLoanById(int loanAppNo);
	List<LoanApplication> viewAllLoanApplications();
	//Customer findCustomerByLoanApplication(int loanAppNo );
	
}
