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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_property")
public class Property {
	@Id
	@SequenceGenerator(name="property_seq",initialValue=2000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="property_seq")
	int propertyId;
	String propertyAddress;
	String mahaReraNo;
	int pincode;
	
	
	@OneToOne(mappedBy="property",cascade=CascadeType.ALL)
	LoanApplication loanApplication;
	
	@JsonIgnore
	public LoanApplication getLoanApplication() {
		return loanApplication;
	}
	@JsonIgnore
	public void setLoanApplication(LoanApplication loanApplication) {
		this.loanApplication = loanApplication;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	
	public String getMahaReraNo() {
		return mahaReraNo;
	}
	public void setMahaReraNo(String mahaReraNo) {
		this.mahaReraNo = mahaReraNo;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	

}
