package com.bankdb.project.model;
import java.sql.Date;

public class Transaction{
	private long idtransaction;
	private double amount;
	private Date dateTime;
	private String kindTransaction;
	private String Observation;
	private String accountnumber;
	public long getIdtransaction() {
		return idtransaction;
	}
	public void setIdtransaction(long idtransaction) {
		this.idtransaction = idtransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getKindTransaction() {
		return kindTransaction;
	}
	public void setKindTransaction(String kindTransaction) {
		this.kindTransaction = kindTransaction;
	}
	public String getObservation() {
		return Observation;
	}
	public void setObservation(String observation) {
		Observation = observation;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	@Override
	public String toString() {
		return "Transaction [idtransaction=" + idtransaction + ", amount=" + amount + ", dateTime=" + dateTime
				+ ", kindTransaction=" + kindTransaction + ", Observation=" + Observation + ", accountnumber="
				+ accountnumber + "]";
	}
	
	
}
