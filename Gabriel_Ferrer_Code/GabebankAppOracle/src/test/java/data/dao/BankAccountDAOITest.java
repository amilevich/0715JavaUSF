package data.dao;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import data.dao.BankAccountDAOI;
import model.BankAccount;
import utility.ds.MapOps;
import value.AccountSharing;
import value.Currency;

public class BankAccountDAOITest {
	static BankAccountDAOI bankdao = new BankAccountDAOI();
	static BankAccount bankAccountJava = new BankAccount(2000.0, Currency.EUR, AccountSharing.JOINT, 1);
	static BankAccount bankAccountDB = bankdao.getOne(1);
	@Test
	public void getOne() {
		assertEquals(bankAccountJava.toString(), bankAccountDB.toString());
	}
	
	@Test
	public void updateDeposit() {
		bankAccountJava.deposit(200.00);
		bankdao.updateOne(bankAccountJava);
		bankAccountDB = bankdao.getOne(1);
		assertEquals(bankAccountJava.getAmount(), bankAccountDB.getAmount());
	}
	
	@Test
	public void updateWithdraw() {
		bankAccountJava.withdraw(200.00);
		bankdao.updateOne(bankAccountJava);
		bankAccountDB = bankdao.getOne(1);
		assertEquals(bankAccountJava.getAmount(), bankAccountDB.getAmount());
	}
	
	@Test
	public void getAll() {
		TreeMap<Integer, BankAccount> bankaccounts = bankdao.getAll();
		Set<Integer> bankaccountNumbers = MapOps.mapToSet(bankaccounts);
		
		assertEquals("[1, 2, 3]", bankaccountNumbers.toString());
	}
	
	@Test
	public void deleteOne() {
		assertEquals(new Integer(0), bankdao.deleteOne(4));
	}
	
	
}
