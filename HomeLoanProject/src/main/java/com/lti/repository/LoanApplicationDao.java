package com.lti.repository;

import java.util.List;

import com.lti.entity.Customer;
import com.lti.entity.LoanApplication;

public interface LoanApplicationDao {

	LoanApplication addOrUpdateLoanApplication(LoanApplication loanApplication, int custId);
	LoanApplication findLoanById(int loanId);
	List<LoanApplication> viewAllLoanApplications();
	//Customer findCustomerByLoanApplication(int loanAppNo );
	
}
