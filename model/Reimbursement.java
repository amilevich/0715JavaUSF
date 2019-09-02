package com.project1.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
	int reimb_ID;
	int reimb_Amount;
	Timestamp reimb_Submitted;
	Timestamp reimb_Resolved;
	String reimb_Description;
	Blob reimb_Receipt;
	int reimb_Author;
	int reimb_Resolver;
	int reimb_Status_ID;
	String reimb_Status;
	int reimb_Type_ID;
	String reimb_Type;
	
	
	public Reimbursement() {
		
	}


	public Reimbursement(int reimb_ID, int reimb_Amount, Timestamp reimb_Submitted, Timestamp reimb_Resolved,
			String reimb_Description, Blob reimb_Receipt, int reimb_Author, int reimb_Resolver, int reimb_Status_ID,
			String reimb_Status, int reimb_Type_ID, String reimb_Type) {
		super();
		this.reimb_ID = reimb_ID;
		this.reimb_Amount = reimb_Amount;
		this.reimb_Submitted = reimb_Submitted;
		this.reimb_Resolved = reimb_Resolved;
		this.reimb_Description = reimb_Description;
		this.reimb_Receipt = reimb_Receipt;
		this.reimb_Author = reimb_Author;
		this.reimb_Resolver = reimb_Resolver;
		this.reimb_Status_ID = reimb_Status_ID;
		this.reimb_Status = reimb_Status;
		this.reimb_Type_ID = reimb_Type_ID;
		this.reimb_Type = reimb_Type;
	}


	public int getReimb_ID() {
		return reimb_ID;
	}


	public void setReimb_ID(int reimb_ID) {
		this.reimb_ID = reimb_ID;
	}


	public int getReimb_Amount() {
		return reimb_Amount;
	}


	public void setReimb_Amount(int reimb_Amount) {
		this.reimb_Amount = reimb_Amount;
	}


	public Timestamp getReimb_Submitted() {
		return reimb_Submitted;
	}


	public void setReimb_Submitted(Timestamp reimb_Submitted) {
		this.reimb_Submitted = reimb_Submitted;
	}


	public Timestamp getReimb_Resolved() {
		return reimb_Resolved;
	}


	public void setReimb_Resolved(Timestamp reimb_Resolved) {
		this.reimb_Resolved = reimb_Resolved;
	}


	public String getReimb_Description() {
		return reimb_Description;
	}


	public void setReimb_Description(String reimb_Description) {
		this.reimb_Description = reimb_Description;
	}


	public Blob getReimb_Receipt() {
		return reimb_Receipt;
	}


	public void setReimb_Receipt(Blob reimb_Receipt) {
		this.reimb_Receipt = reimb_Receipt;
	}


	public int getReimb_Author() {
		return reimb_Author;
	}


	public void setReimb_Author(int reimb_Author) {
		this.reimb_Author = reimb_Author;
	}


	public int getReimb_Resolver() {
		return reimb_Resolver;
	}


	public void setReimb_Resolver(int reimb_Resolver) {
		this.reimb_Resolver = reimb_Resolver;
	}


	public int getReimb_Status_ID() {
		return reimb_Status_ID;
	}


	public void setReimb_Status_ID(int reimb_Status_ID) {
		this.reimb_Status_ID = reimb_Status_ID;
	}


	public String getReimb_Status() {
		return reimb_Status;
	}


	public void setReimb_Status(String reimb_Status) {
		this.reimb_Status = reimb_Status;
	}


	public int getReimb_Type_ID() {
		return reimb_Type_ID;
	}


	public void setReimb_Type_ID(int reimb_Type_ID) {
		this.reimb_Type_ID = reimb_Type_ID;
	}


	public String getReimb_Type() {
		return reimb_Type;
	}


	public void setReimb_Type(String reimb_Type) {
		this.reimb_Type = reimb_Type;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimb_ID=" + reimb_ID + ", reimb_Amount=" + reimb_Amount + ", reimb_Submitted="
				+ reimb_Submitted + ", reimb_Resolved=" + reimb_Resolved + ", reimb_Description=" + reimb_Description
				+ ", reimb_Receipt=" + reimb_Receipt + ", reimb_Author=" + reimb_Author + ", reimb_Resolver="
				+ reimb_Resolver + ", reimb_Status_ID=" + reimb_Status_ID + ", reimb_Status=" + reimb_Status
				+ ", reimb_Type_ID=" + reimb_Type_ID + ", reimb_Type=" + reimb_Type + "]";
	}
	
	

}
