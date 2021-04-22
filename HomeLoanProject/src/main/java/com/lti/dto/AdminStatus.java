package com.lti.dto;

import com.lti.dto.Status.StatusType;

public class AdminStatus extends Status{
	private int adminId;
    private String adminName;
    
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
    
}
