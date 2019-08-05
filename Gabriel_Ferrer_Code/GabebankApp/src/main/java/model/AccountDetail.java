package model;

import java.io.Serializable;

import value.*;

public class AccountDetail implements Serializable {

	private static final long serialVersionUID = 6981476971144019L;
	/**
	 * 
	 */
	
	protected Double amount;
	protected Currency currency;
	protected AccountSharing accountSharing;
	public AccountDetail() {};
	public AccountDetail(Double amount, Currency currency, AccountSharing accountSharing) {
		this.amount = amount;
		this.currency = currency;
		this.accountSharing = accountSharing;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public AccountSharing getAccountSharing() {
		return accountSharing;
	}
	public void setAccountSharing(AccountSharing accountSharing) {
		this.accountSharing = accountSharing;
	}
	
	
	@Override
	public String toString() {
		return "AccountDetail [amount=" + amount + ", currency=" + currency + ", accountSharing=" + accountSharing
				+ "]";
	}
}
