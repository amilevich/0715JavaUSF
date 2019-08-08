package daoism;

import items.Account;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountDaoImpl adi = new AccountDaoImpl();
		Account a = new Account("Sam", "isCool",100000.0,"Sam", "Jones");
		adi.insertAccount(a);
		
		System.out.println(adi.selectAccountByUsername("Sam"));
	}

}
