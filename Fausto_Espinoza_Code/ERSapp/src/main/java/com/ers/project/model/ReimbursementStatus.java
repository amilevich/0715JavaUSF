package com.ers.project.model;


public class ReimbursementStatus{
	
	private long statusId;
	private String statusName;
	
	
	public long getStatusId() {
		return statusId;
	}
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
	

}
