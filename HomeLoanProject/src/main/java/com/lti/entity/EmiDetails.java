package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_emidetails")
public class EmiDetails {
	@Id
	@SequenceGenerator(name="emi_seq",initialValue=5000,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="emi_seq")
	int emiId;
	int perMonthEmi;
	int tenure;
	int balAmt;
	int amtPaid;
	int interestRate;

	// int loanAppNo;
	@OneToOne
	@JoinColumn(name="loanAppNo")
	LoanApplication loanApplication;
	
	
	public int getEmiId() {
		return emiId;
	}

	public void setEmiId(int emiId) {
		this.emiId = emiId;
	}

	public LoanApplication getLoanApplication() {
		return loanApplication;
	}

	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	public int getPerMonthEmi() {
		return perMonthEmi;
	}

	public void setPerMonthEmi(int perMonthEmi) {
		this.perMonthEmi = perMonthEmi;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public int getBalAmt() {
		return balAmt;
	}

	public void setBalAmt(int balAmt) {
		this.balAmt = balAmt;
	}

	public int getAmtPaid() {
		return amtPaid;
	}

	public void setAmtPaid(int amtPaid) {
		this.amtPaid = amtPaid;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

}
