package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_incomedetails")
public class IncomeDetails {
	@Id
	@SequenceGenerator(name="income_seq",initialValue=3000,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="income_seq")
	int incomeId;
	String occupation;
	String nameOfOrg;
	String typeOfOrg;
	int monthlyIncome;
	int creditScore;

	// int loanAppNo;
	@OneToOne(mappedBy="incomeDetails",cascade=CascadeType.ALL)
	LoanApplication loanApplication;
	 
	
	public int getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNameOfOrg() {
		return nameOfOrg;
	}

	public void setNameOfOrg(String nameOfOrg) {
		this.nameOfOrg = nameOfOrg;
	}

	public String getTypeOfOrg() {
		return typeOfOrg;
	}

	public void setTypeOfOrg(String typeOfOrg) {
		this.typeOfOrg = typeOfOrg;
	}

	public int getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(int monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
	
	
	
}
