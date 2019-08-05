package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.github.freva.*;
import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;

import model.Application;
import model.BankAccount;
import model.Customer;
import seed.PrimaryModels;

public class PrintTable {
	public static void displayAccounts() {
		String[] headers = {"Account Number", "Amount", "Currency", "Account Type"};
		
		String[][] accounts = new String[ BankAccount.getSize() ][ 4 ];
		System.out.println( BankAccount.getSize() );
		int i = 0;
		
		for (Integer number : BankAccount.getAll().keySet()) {
			accounts[i][0] = number.toString();
			accounts[i][1] = BankAccount.get(number).getAmount().toString();
			accounts[i][2] = BankAccount.get(number).getCurrency().toString();
			accounts[i][3] = BankAccount.get(number).getAccountSharing().toString();
			++i;
		}
		
		System.out.println("-----------------List of Bank Accounts----------------");
		System.out.println(AsciiTable.getTable(headers, accounts));
	}
	
	public static void displayApplications() {
		String[] headers = {"Application Number", "Amount", "Currency", "Account Type", "Applicant Names" };
		
		String[][] applications = new String[Application.getSize()][5];
		Integer i = 0;
		System.out.println(  Application.getSize());
		
		for(Integer number : Application.getAll().keySet())  {
			try {
				applications[i][0] = number.toString();
				applications[i][1] = Application.getOne(number).getAccountDetail().getAmount().toString();
				applications[i][2] = Application.getOne(number).getAccountDetail().getCurrency().toString();
				applications[i][3] = Application.getOne(number).getAccountDetail().getAccountSharing().toString();
				applications[i][4] = Application.getOne(number).getApplicantNames();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			++i;
		}
		System.out.println("---------------------------------------List of Applications---------------------------------------");
		System.out.println(AsciiTable.getTable(headers, applications));
	}
	
	public static void displayCustomers() {
		String[] headers = { "Username", "Accounts Owned", "Firstname", "Lastname" };
		String[][] customers = new String[Customer.getSize()][4];
		int i = 0;
		
		for (String username : Customer.getAll().keySet()) {
			customers[i][0] = username;
			customers[i][1] = Customer.getCustomer(username).getBankAccountNumbers().toString();
			customers[i][2] = Customer.getCustomer(username).getFirstName();
			customers[i][3] = Customer.getCustomer(username).getLastName();
			++i;
		}
		System.out.println("--------List of Customers-----------");
		System.out.println(AsciiTable.getTable(headers, customers));
	}
	
	public static void main(String[] args) {
		PrimaryModels.seed();
		displayAccounts();
		displayApplications();
		displayCustomers();
		
	}
}
