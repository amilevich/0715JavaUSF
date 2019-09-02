package com.ers.project.model;

import java.sql.Blob;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;


public class ReimbursementTicket {
	private long reimbId;
	private double reimbAmount;
	@JsonFormat(pattern = "MMM-dd-yyyy")
	private Timestamp reimbSubmitted;
	@JsonFormat(pattern = "MMM-dd-yyyy")
	private Timestamp reimbResolved;
	private String reimbDescription;
	private Blob blob;
	private long reimbAuthor;
	private long reimbResolver;
	private long reimbstatusId;
	private long reimbtypeId;
	public long getReimbId() {
		return reimbId;
	}
	public void setReimbId(long reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
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
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public long getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(long reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public long getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(long reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public long getReimbstatusId() {
		return reimbstatusId;
	}
	public void setReimbstatusId(long reimbstatusId) {
		this.reimbstatusId = reimbstatusId;
	}
	public long getReimbtypeId() {
		return reimbtypeId;
	}
	public void setReimbtypeId(long reimbtypeId) {
		this.reimbtypeId = reimbtypeId;
	}
	@Override
	public String toString() {
		return "ReimbursementTicket [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", blob=" + blob + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbstatusId=" + reimbstatusId + ", reimbtypeId=" + reimbtypeId + "]";
	}
	
	
}
