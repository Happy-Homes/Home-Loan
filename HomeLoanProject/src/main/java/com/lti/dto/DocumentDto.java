package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class DocumentDto {
	private int docId;
	
    private MultipartFile pan,aadhar,loa,salesDeed,paySlip,bankStatement,noc,incomeTax;
    
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public MultipartFile getPan() {
		return pan;
	}
	public void setPan(MultipartFile pan) {
		this.pan = pan;
	}
	public MultipartFile getAadhar() {
		return aadhar;
	}
	public void setAadhar(MultipartFile aadhar) {
		this.aadhar = aadhar;
	}
	public MultipartFile getLoa() {
		return loa;
	}
	public void setLoa(MultipartFile loa) {
		this.loa = loa;
	}
	public MultipartFile getSalesDeed() {
		return salesDeed;
	}
	public void setSalesDeed(MultipartFile salesDeed) {
		this.salesDeed = salesDeed;
	}
	public MultipartFile getPaySlip() {
		return paySlip;
	}
	public void setPaySlip(MultipartFile paySlip) {
		this.paySlip = paySlip;
	}
	public MultipartFile getBankStatement() {
		return bankStatement;
	}
	public void setBankStatement(MultipartFile bankStatement) {
		this.bankStatement = bankStatement;
	}
	public MultipartFile getNoc() {
		return noc;
	}
	public void setNoc(MultipartFile noc) {
		this.noc = noc;
	}
	public MultipartFile getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(MultipartFile incomeTax) {
		this.incomeTax = incomeTax;
	}

}
