package com.employeeScreen;

import java.util.Scanner;

import com.mainmenu.MainScreen;
import com.uncertainty.Account;
import com.uncertainty.Customer;
import com.employeeScreen.ApproveDeny;

public class EmployeePostLoginMenu {

	public void EmplyMenuTime() {Scanner emplyChoice = new Scanner(System.in);
	int op; 
	
	{
	do {
		System.out.println("1. Approve Accounts");
		System.out.println("2. Check Account balances");
		System.out.println("3. Lookup customer info");
		System.out.println("4. Exit");
		System.out.println("Please select an option.");
		op = emplyChoice.nextInt();
		
		

		switch (op) {
		case 1:
			ApproveDeny ad = new ApproveDeny();
			ad.ApproveDenyInterface();
			break;
		case 2:
			CheckBalance ck = new CheckBalance();
			ck.chequeBal();
			break;
			
		case 3:
			CustInfoLookup lk = new CustInfoLookup();
			lk.custInfoLookup();
			break;

		default:
			if (op != 4)
				System.out.println("Not a valid option.");
			break;
		}
	} while (op != 4);
}
}

}
