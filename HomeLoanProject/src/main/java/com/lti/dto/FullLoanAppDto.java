package com.lti.dto;

import java.time.LocalDate;

import com.lti.entity.LoanStatus;

public class FullLoanAppDto {
	int fullId;
	int custId;
	String custName;
	LocalDate custDob;
	String custEmail;
	String custPhone;
	int custAge;
	String custAddress;
	String custGender;
	String custPan;
	String custAadhar;
	String custPassword;
	String occupation;
	String nameOfOrg;
	String typeOfOrg;
	int monthlyIncome;
	int creditScore;
	double amountRequired;
	double tenure;
	LoanStatus LoanStatus;
	double amountSanctioned;
	String propertyAddress;
	int mahaReraNo;
	int pincode;

	public int getFullId() {
		return fullId;
	}

	public void setFullId(int fullId) {
		this.fullId = fullId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public LocalDate getCustDob() {
		return custDob;
	}

	public void setCustDob(LocalDate custDob) {
		this.custDob = custDob;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public String getCustPan() {
		return custPan;
	}

	public void setCustPan(String custPan) {
		this.custPan = custPan;
	}

	public String getCustAadhar() {
		return custAadhar;
	}

	public void setCustAadhar(String custAadhar) {
		this.custAadhar = custAadhar;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
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

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public int getMahaReraNo() {
		return mahaReraNo;
	}

	public void setMahaReraNo(int mahaReraNo) {
		this.mahaReraNo = mahaReraNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
