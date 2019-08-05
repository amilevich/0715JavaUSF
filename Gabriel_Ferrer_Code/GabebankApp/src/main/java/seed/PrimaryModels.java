package seed;

import java.util.ArrayList;

import model.AccountDetail;
import model.Applicant;
import model.Application;
import model.BankAccount;
import model.Customer;
import model.Employee;
import model.UserAccount;
import value.*;

public class PrimaryModels {
	public static void seed() {
		//////Customer Details
		new UserAccount("gabriel", "gabrieL675!");      /// customer
		new UserAccount("genevieve", "genevi&W4");  	/// customer
		new BankAccount(2000.00, Currency.EUR, AccountSharing.INDIVIDUAL, 1);
		new BankAccount(2000.00, Currency.EUR, AccountSharing.INDIVIDUAL, 2);
		new BankAccount(3000.00, Currency.EUR, AccountSharing.INDIVIDUAL, 3);
		Customer gabriel = new Customer("Gabriel","Ferrer","gabriel",1);
		gabriel.addBankAccount(3);
		new Customer("Genevieve","Ferrer","genevieve",2);
		//////Employee Details
		new UserAccount("geneferr", "geneferr21!B");      /// customer
		new UserAccount("juana2", "juanA2!");  	/// customer
		new Employee("Guillermo", "Ferrer", "geneferr", "geneferr21!B", true);
		new Employee("Jane", "Ferrer", "juana2", "juanA2!", false);
		
		///// Applications
		//// Individual 1 and 2
		ArrayList<Applicant> applicant1 = new ArrayList<Applicant>(); /// array of applicants
		AccountDetail accountDetail1 = new AccountDetail(900.98, Currency.EUR, AccountSharing.INDIVIDUAL); /// AccountDetail for individual1
		AccountDetail accountDetail2 = new AccountDetail(400.98, Currency.USD, AccountSharing.INDIVIDUAL); /// AccountDetail for individual2
		
		Applicant individual1 = new Applicant("Nelson", "Cruz", "nelson", "4w8O@!*L"); /// Applicant
		applicant1.add(individual1); /// add applicant to applicants
		ArrayList<Applicant> applicant2 = new ArrayList<Applicant>(); /// array of applicants
		Applicant individual2 = new Applicant("Robert", "Mandela", "robert", "kLOp$g^33"); /// Applicant
		applicant2.add(individual2); /// add applicant to applicants
		
		Application iApplication1 = new Application(applicant1, accountDetail1); /// create a new application
		Application iApplication2 = new Application(applicant2, accountDetail2); /// create a new application
		
		///// Applications
		//// Joint 1
		ArrayList<Applicant> applicants = new ArrayList<Applicant>();
		AccountDetail jointAccountDetail = new AccountDetail(500.00, Currency.EUR, AccountSharing.JOINT); /// AccountDetail for individual1
		Applicant joint1 = new Applicant("Evangeline", "Rosales", "evange", "jKwHl677W#"); /// Applicant
		applicants.add(joint1); /// add applicant to applicants
		Applicant joint2 = new Applicant("Tonya", "Morales", "tonya21", "fGh23As66&"); /// Applicant
		applicants.add(joint2); /// add applicant to applicants
		
		Application jApplication = new Application(applicants, jointAccountDetail); /// create a new application
		
	}
	
	public static void main(String[] args) {
		seed();
	}
}
