package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_document")
public class LoanDocument {

	@SequenceGenerator(name = "doc_seq", initialValue = 6000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_seq")
	@Id
	int docId;
	String pan;
	String aadhar;
	String loa;
	String salesDeed;
	String paySlip;
	String bankStatement;
	String noc;
	String incomeTax;

	// loanApplNo fk;

	@OneToOne
	@JoinColumn(name = "loanAppNo")
	LoanApplication loanApplication;

	@OneToOne
	@JoinColumn(name = "custId")
	Customer customer;

	

	public int getDocId() {
		return docId;
	}
	@JsonIgnore
	public LoanApplication getLoanApplication() {
		return loanApplication;
	}
	@JsonIgnore
	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getLoa() {
		return loa;
	}

	public void setLoa(String loa) {
		this.loa = loa;
	}

	public String getSalesDeed() {
		return salesDeed;
	}

	public void setSalesDeed(String salesDeed) {
		this.salesDeed = salesDeed;
	}

	public String getPaySlip() {
		return paySlip;
	}

	public void setPaySlip(String paySlip) {
		this.paySlip = paySlip;
	}

	public String getBankStatement() {
		return bankStatement;
	}

	public void setBankStatement(String bankStatement) {
		this.bankStatement = bankStatement;
	}

	public String getNoc() {
		return noc;
	}

	public void setNoc(String noc) {
		this.noc = noc;
	}

	public String getIncomeTax() {
		return incomeTax;
	}

	public void setIncomeTax(String incomeTax) {
		this.incomeTax = incomeTax;
	}

}
