package bank.running;

import java.util.Scanner;
import java.util.List;
import java.util.Map.Entry;

import bank.accounts.User;
import bank.menu.Instructions;
import dao.models.Customer;
import dao.models.CustomerDAOImpl;
import dao.models.UsernameDAOImpl;
import db.bank.admin.AdminDBM;

//class runs program
public class Runner 
{
	public static void main(String[] args) 
	{				

		CustomerDAOImpl make = new CustomerDAOImpl();
//		Customer du = new Customer(108, 0, 500, "pending", "boondock", "sun", "danny", "Amonsin", "personal");
//		make.createCAcct(du);
		AdminDBM aDbm = new AdminDBM();
//	System.out.println(doe.userNameChecker("bood").getUserName());
//		System.out.println(doe.findPendingAcctDB);
//		System.out.println(doe.findPersRelAcct("d").getAccount_id());
//		make.updateCustDBbalance(117, 3902);
//		make.updateCustDB(117, "deny");
		aDbm.getDBbalance(115);		
		
		Instructions instruc = new Instructions();
		instruc.empStr();
		instruc.instrStart(); //shows instructions for main menu
		
				
	}
	
}
