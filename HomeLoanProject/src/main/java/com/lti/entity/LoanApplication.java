package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_loanapplication")
public class LoanApplication {
	@Id
	@SequenceGenerator(name = "loanapp_seq", initialValue = 4000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loanapp_seq")
	int loanAppNo;
	double amountRequired;
	double tenure;
	LoanStatus LoanStatus;
	double amountSanctioned;
	// int cust_id;fk

	@ManyToOne
	@JoinColumn(name = "custId")
	Customer customer;

	@OneToOne(mappedBy = "loanApplication")
	EmiDetails emiDetails;

	@OneToOne
	@JoinColumn(name = "incomeId")
	IncomeDetails incomeDetails;

	@OneToOne
	@JoinColumn(name = "propertyId")
	Property property;

	@OneToOne(mappedBy = "loanApplication")
	LoanDocument loanDocument;

	public LoanDocument getLoanDocument() {
		return loanDocument;
	}

	public void setLoanDocument(LoanDocument loanDocument) {
		this.loanDocument = loanDocument;
	}

	public int getLoanAppNo() {
		return loanAppNo;
	}

	public void setLoanAppNo(int loanAppNo) {
		this.loanAppNo = loanAppNo;
	}

	public double getAmountRequired() {
		return amountRequired;
	}

	public void setAmountRequired(double amountRequired) {
		this.amountRequired = amountRequired;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public LoanStatus getLoanStatus() {
		return LoanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		LoanStatus = loanStatus;
	}

	public double getAmountSanctioned() {
		return amountSanctioned;
	}

	public void setAmountSanctioned(double amountSanctioned) {
		this.amountSanctioned = amountSanctioned;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}
	@JsonIgnore
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@JsonIgnore
	public EmiDetails getEmiDetails() {
		return emiDetails;
	}
	@JsonIgnore
	public void setEmiDetails(EmiDetails emiDetails) {
		this.emiDetails = emiDetails;
	}

	public IncomeDetails getIncomeDetails() {
		return incomeDetails;
	}

	public void setIncomeDetails(IncomeDetails incomeDetails) {
		this.incomeDetails = incomeDetails;
	}
	@JsonIgnore
	public Property getProperty() {
		return property;
	}
	@JsonIgnore
	public void setProperty(Property property) {
		this.property = property;
	}

}
