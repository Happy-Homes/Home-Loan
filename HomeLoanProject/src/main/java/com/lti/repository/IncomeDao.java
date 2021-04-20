package com.lti.repository;

import com.lti.entity.IncomeDetails;

public interface IncomeDao {
	IncomeDetails addOrUpdateIncome(IncomeDetails incomeDetails);
	IncomeDetails findIncomeById(int incomeId);

}
