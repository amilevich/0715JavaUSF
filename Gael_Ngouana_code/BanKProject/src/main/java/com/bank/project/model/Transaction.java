package com.bank.project.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction extends Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4898121863634736187L;
	private double amount;
	private LocalDateTime dateTime;
	private char kindTransaction;
	private String Observation;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public char getKindTransaction() {
		return kindTransaction;
	}
	public void setKindTransaction(char kindTransaction) {
		this.kindTransaction = kindTransaction;
	}
	public String getObservation() {
		return Observation;
	}
	public void setObservation(String observation) {
		Observation = observation;
	}
	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", dateTime=" + dateTime + ", kindTransaction=" + kindTransaction
				+ ", Observation=" + Observation + "]";
	}
	
	
	
		
}
