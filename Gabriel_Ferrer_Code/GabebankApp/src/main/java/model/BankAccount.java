package model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;
import org.apache.log4j.Logger;

import value.AccountSharing;
import value.Currency;

public class BankAccount extends AccountDetail implements Serializable {

	/**
	 * @author Gabriel Ferrer
	 */
	private static final long serialVersionUID = 675094771209049635L;
	final static Logger logger = Logger.getLogger(BankAccount.class);
	public static TreeMap<Integer, BankAccount> bankAccounts = new TreeMap<Integer, BankAccount>();
	private static Integer counter = 0;
	private Integer number;

	///constructors
	public BankAccount() {
		super();
	};
	
	public BankAccount(Double amount, Currency currency, AccountSharing accountSharing, Integer bankAccountNumber) {
		super(amount, currency, accountSharing);
		this.number = bankAccountNumber;
		bankAccounts.put(bankAccountNumber, this);
		++counter;
	}
	
	public BankAccount(Double amount, Currency currency, AccountSharing accountSharing) {
		super(amount, currency, accountSharing);
		this.number = ++counter;
		bankAccounts.put(this.number, this);
		logger.info(String.format("Bank Account number %1$s was created for %2$s account", this.number, super.accountSharing.toString()));
	}
	
	//// object methods
	public void deposit (Double amount) {
		super.amount += amount;
		logger.info(String.format("%1$s %2$s was deposited to Bank Account number %3$s", super.accountSharing.toString(), super.amount, this.number));
	}
	
	public void withdraw (Double amount) {
		super.amount -= amount;
		logger.info(String.format("%1$s %2$s was withdrawn from Bank Account number %3$s", super.accountSharing.toString(), super.amount, this.number));
	}
	
	public boolean notOverdraft (Double amount) {
		return super.amount >= amount;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	///// static methods
	public static void remove(Integer bankAccountReference) {
		/// use dao for this
		bankAccounts.remove(bankAccountReference);
	}
	
	public static BankAccount get(Integer bankAccountReference) {
		return bankAccounts.get(bankAccountReference);
	}

	public static TreeMap<Integer, BankAccount> getAll() {
		return bankAccounts;
	}
	
	public static void setAll(TreeMap<Integer, BankAccount> ba) {
		bankAccounts = ba;
	}
	
	public static Integer getSize() {
		return bankAccounts.size();
	}
	
	public static void setCounter(Integer n) {
		counter = n;
	}
	
	public static Integer getCounter() {
		return counter;
	}
	
	public static boolean exists (Integer bankAccountNumber) {
		return bankAccounts.containsKey(bankAccountNumber);
	}
	
	public static Set<Integer> getNumbers () {
		return bankAccounts.keySet();
	}
	
	
	
	@Override
	public String toString() {
		return "BankAccount [amount=" + amount + ", currency=" + currency + ", accountSharing=" + accountSharing + "]";
	}
	
	
}
