package com.lti.service;

import com.lti.entity.IncomeDetails;

public interface IncomeService {
		IncomeDetails updateIncome(IncomeDetails incomeDetails);
		IncomeDetails findIncomeById(int incomeId);
}
