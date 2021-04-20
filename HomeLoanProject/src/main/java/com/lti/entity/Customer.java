package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customer")
public class Customer {

	@Id
	@SequenceGenerator(name = "cust_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
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
	private String profilePic;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	List<LoanApplication> loanApplication;

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

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/*
	 * public List<LoanApplication> getLoanApplication() { return loanApplication; }
	 * 
	 * public void setLoanApplication(List<LoanApplication> loanApplication) {
	 * this.loanApplication = loanApplication; }
	 */

}