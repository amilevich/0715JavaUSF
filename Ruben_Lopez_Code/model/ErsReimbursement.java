package com.revature.model;
import java.sql.Timestamp;

import java.sql.Blob;
public class ErsReimbursement {
	
	
	

	int reimbId = 0 ;
	
	int reimbAmount = 0;

	Timestamp reimbSubmitted = null;

	Timestamp reimbResolved = null;

	String reimbDescription = "";
	
	Blob reimbReceipt = null;

	int reimbAuthor = 0;

	int reimbResolver = 0;

	int reimbStatusId = 0;

	int reimbTypeId = 0;

	public int getReimbID() {
		return reimbId;
	}

	public void setReimbID(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public Blob getReimbReceipt() {
		return reimbReceipt;
	}

	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatusID() {
		return reimbStatusId;
	}

	public void setReimbStatusID(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeID(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	

	public ErsReimbursement(int reimbId, int reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, Blob reimbReceipt, int reimbAuthor, int reimbResolver, int reimbStatusId,
			int reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}
	
	public ErsReimbursement() {
		
	}
	
	
	

}
