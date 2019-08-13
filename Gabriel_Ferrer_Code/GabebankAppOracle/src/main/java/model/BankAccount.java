package model;

import value.AccountSharing;
import value.Currency;

public class BankAccount extends AccountDetail {
	private Integer number;
	
	public BankAccount(Double amount, Currency currency, AccountSharing accountSharing, Integer bankAccountNumber) {
		super(amount, currency, accountSharing);
		this.number = bankAccountNumber;
	}
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	//// object methods
	public void deposit (Double amount) {
		super.amount += amount;
		
	}
	
	public void withdraw (Double amount) {
		super.amount -= amount;
	}
	
	public boolean isOverdraft (Double amount) {
		return amount > super.amount;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "BankAccount [amount=" + amount + ", currency=" + currency + ", accountSharing=" + accountSharing + "]";
	}
}
