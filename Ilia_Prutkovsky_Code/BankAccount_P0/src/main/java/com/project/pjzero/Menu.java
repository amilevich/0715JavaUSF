package com.project.pjzero;

import com.project.db.*;
import com.project.actions.*;

import java.io.IOException;
import java.sql.SQLException;

public class Menu {

	static ScanReader sc = new ScanReader(System.in);
	static int num;
	static CustomerDaoImp customerDaoImp = new CustomerDaoImp();
	static CustomerDaoImp1 customerDaoImp1 = new CustomerDaoImp1();

	public static void mainMenu() throws IOException, SQLException {

		System.out.print("Please choose one of menu point: \n");

		do {
			System.out.println(" 1 - Create new account of banking system");
			System.out.println(" 2 - Login to banking system");
			num = sc.scanInt();

			switch (num) {
			case 1:
//				customerDaoImp.insertPendingCustomer();
				customerDaoImp1.createCustomer();
				//LocalDB.addToTempDB();
				break;
			case 2:
				Menu.loginMenu();
				break;
			default:
				System.out.println("You have to chose from 1 to 2 for contiue\n");
			}
		} while (num != 2);
	}

	public static void loginMenu() throws IOException, SQLException {

		System.out.print("Please choose one of menu point: \n");

		do {
			System.out.println(" 1 - Login as Customer");
			System.out.println(" 2 - Login as Employee");
			System.out.println(" 3 - Login as Admin");
			System.out.println(" 4 - Back to main menu");
			num = sc.scanInt();

			switch (num) {
			case 1:
				//EmployeeActions.userLogin();
//				customerDaoImp.customerLogin();
				customerDaoImp1.customerLogin();
				Menu.customerMenu();
				break;
			case 2:
				EmployeeActions.employeeLogin();
				Menu.employeeMenu();
				break;
			case 3:
				EmployeeActions.adminLogin();
				Menu.adminMenu();
				break;
			case 4:
				Menu.mainMenu();
				break;
			default:
				System.out.println("You have to chose from 1 to 4 for contiue\n");
			}
		} while (num != 4);
	}

	public static void customerMenu() throws IOException, SQLException {
		System.out.print("Please choose one of menu point: \n");

		do {
			System.out.println(" 1 - Full information about your account");
			System.out.println(" 2 - Deposit");
			System.out.println(" 3 - Withdraw");
			System.out.println(" 4 - Transfer");
			System.out.println(" 5 - Join another account");
			System.out.println(" 6 - Back to login menu (previous menu)");
			System.out.println(" 7 - Back to main menu");
			num = sc.scanInt();

			switch (num) {
			case 1:
//				customerDaoImp.readCustomerInfoFromWorkDB();
				customerDaoImp1.readCustomerInfo();
				break;
			case 2:
//				customerDaoImp.customerDeposit();
				customerDaoImp1.customerDeposit();
//				LocalDB.customerDeposit(null, 0.0);
				break;
			case 3:
//				customerDaoImp.customerWithdraw();
				customerDaoImp1.customerWithdraw();
//				LocalDB.customerWithdraw(null, 0.0);
				break;
			case 4:
//				customerDaoImp.customerBalanceTransfer();
				customerDaoImp1.customerBalanceTransfer();
//				LocalDB.customerBalanceTransfer(null, 0.0);
				break;
			case 5:
				customerDaoImp.joinCustomer();
//				LocalDB.customersJoin(null);
				break;
			case 6:
				Menu.loginMenu();
				break;
			case 7:
				Menu.mainMenu();
				break;
			default:
				System.out.println("You have to chose from 1 to 7 for contiue\n");
			}
		} while (num != 7);
	}

	public static void employeeMenu() throws IOException, SQLException {
		System.out.print("Please choose one of menu point: \n");

		do {
			System.out.println(" 1 - View information about customer");
			System.out.println(" 2 - Back to login menu (previous menu)");
			System.out.println(" 3 - Back to main menu");
			num = sc.scanInt();

			switch (num) {
			case 1:
//				customerDaoImp.readFullInfoFromWorkDB();
				customerDaoImp1.readCustomersInfo();
//				LocalDB.readFromWorkDB();
				break;
			case 2:
				Menu.loginMenu();
				break;
			case 3:
				Menu.mainMenu();
				break;
			default:
				System.out.println("You have to chose from 1 to 3 for contiue\n");
			}
		} while (num != 3);
	}

	public static void adminMenu() throws IOException, SQLException {
		System.out.print("Please choose one of menu point: \n");

		do {
			System.out.println(" 1 - Changing status of customer");
			System.out.println(" 2 - View list of customers");
			System.out.println(" 3 - Cancel customer's account");
			System.out.println(" 4 - Back to login menu (previous menu)");
			System.out.println(" 5 - Back to main menu");
			num = sc.scanInt();

			switch (num) {
			case 1:
//				customerDaoImp.copyToWorkDB();
				customerDaoImp1.changeCustomerStatusToApproved();
				//LocalDB.copyToWorkDB(null);
				break;
			case 2:
//				customerDaoImp.readFullInfoFromWorkDB();
				customerDaoImp1.readCustomersInfo();
				//LocalDB.readFromWorkDB();
				break;
			case 3:
				customerDaoImp1.changeCustomerStatusToCancel();
//				Menu.adminCancelMenu();
				break;
			case 4:
				Menu.loginMenu();
				break;
			case 5:
				Menu.mainMenu();
				break;
			default:
				System.out.println("You have to chose from 1 to 5 for contiue\n");
			}
		} while (num != 5);
	}

	public static void adminCancelMenu() throws IOException, SQLException {
		System.out.print("Please choose one of menu point: \n");

		do {
			System.out.println(" 1 - Cancel pending customer");
			System.out.println(" 2 - Cancel approved customer");
			System.out.println(" 3 - Back to previous menu");
			System.out.println(" 4 - Back to login menu (previous menu)");
			System.out.println(" 5 - Back to main menu");
			num = sc.scanInt();

			switch (num) {
			case 1:
				customerDaoImp.deletePendingCustomer();
				//LocalDB.deleteFromTempDB();
				break;
			case 2:
				customerDaoImp.deleteFromWorkDB();
//				LocalDB.deleteFromWorkDB();
				break;
			case 3:
				Menu.adminMenu();
				break;
			case 4:
				Menu.loginMenu();
				break;
			case 5:
				Menu.mainMenu();
				break;
			default:
				System.out.println("You have to chose from 1 to 5 for contiue\n");
			}
		} while (num != 5);
	}
}
