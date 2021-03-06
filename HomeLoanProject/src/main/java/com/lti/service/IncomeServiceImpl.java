package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.IncomeDetails;
import com.lti.repository.IncomeDao;
@Service
public class IncomeServiceImpl implements IncomeService {
	
	@Autowired
	IncomeDao incomeDao;

	@Override
	public IncomeDetails updateIncome(IncomeDetails incomeDetails) {
		
		IncomeDetails incDetails= incomeDao.addOrUpdateIncome(incomeDetails);
		return incDetails;
	}

	@Override
	public IncomeDetails findIncomeById(int incomeId) {
		
		return incomeDao.findIncomeById(incomeId);
	}

}
