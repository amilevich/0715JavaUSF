package dao;

import beans.Account;
import beans.User;
import menus.MainMenu;

public class Driver {
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.firstLoginMenu();
//		
//		UserDimple udi = new UserDimple();
//		System.out.println(udi.findUserByUsername("aid").getUsername());
//		UserDimple udi = new UserDimple();
//		User u2 = udi.findUserByUsername("admin");
////		User u2 = t.login("admin", "admin");
//		System.out.println(u2.getUsername() + u2.getPassword());
//		Transaction createUser = new Transaction();
////		createUser.createUser("sambroni", "pw");
//		Transaction insertLookup = new Transaction();
//		insertLookup.insertIntoJunction("wooot");
//		insertLookup.insertIntoJunction("sam", "pw");
//		udi.insertUser(new User("Sambo","Sambo"));
//		Account a2 = new Account("2",1000.0,false);
//		Transaction deposit = new Transaction();
//		deposit.deposit("1",100.0);
//		Transaction withdraw = new Transaction();
////		withdraw.withdraw("1", 40.0);
//		Transaction delete = new Transaction();
//////		delete.deleteAccountByAID("1");
//		Transaction approve = new Transaction();
//		approve.approveAccountByAID("1");
////		adi.insertAccount(a2);
//		Transaction transfer = new Transaction();
//		transfer.transferAmount("2", "1", 100.0);
	}
}
