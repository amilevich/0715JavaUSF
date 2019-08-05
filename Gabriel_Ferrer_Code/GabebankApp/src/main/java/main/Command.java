package main;


import java.util.ArrayList;
import java.util.Set;

import exception.AmountException;
import model.AccountDetail;
import model.Applicant;
import model.Application;
import model.BankAccount;
import model.UserAccount;
import value.AccountSharing;
import value.Currency;

public class Command {
	
	public static class Customer {
		public static class New {
			public static Application application;
			public static ArrayList<Applicant> applicants = new ArrayList<Applicant>();
			public static AccountDetail accountDetail = new AccountDetail();

			public static class Individual {
				static void apply() {
					new Application(applicants, accountDetail);
					applicants = new ArrayList<Applicant>();
					application = new Application();
					accountDetail = new AccountDetail();
				}

				static void addApplicant(String firstname, String lastname, String username, String password) {
					applicants.add(new Applicant(firstname, lastname, username, password));
				}

				static void addAccountDetail(Double amount, Currency currency) {
					accountDetail = new AccountDetail(amount, currency, AccountSharing.INDIVIDUAL);
				}
			}

			static class Joint {
				static void apply() {
					new Application(applicants, accountDetail);
					applicants = new ArrayList<Applicant>();
					application = new Application();
					accountDetail = new AccountDetail();
				}

				static void addApplicant(String firstname, String lastname, String username, String password) {
					applicants.add(new Applicant(firstname, lastname, username, password));
				}

				static void addAccountDetail(Double amount, Currency currency) {
					accountDetail = new AccountDetail(amount, currency, AccountSharing.JOINT);
				}
			}
		}

		public static class Existing {
			public static UserAccount userAccounts = new UserAccount();
			public static BankAccount bankAccount;
			public static model.Customer customer;
			public static boolean userExists;

			public static class Do {
				static boolean verify(String username, String password) {
					userExists = UserAccount.exists(username, password);
					customer = model.Customer.getCustomer(username);
					return userExists;
				}

				static boolean verify(Integer bankAccountNumber) {
					return model.BankAccount.exists(bankAccountNumber);
				}
			}

			public static class AbilityTo {//extends Program.Employee.Regular.AbilityTo.View.BankAccount {
				static Set<Integer> viewAll() {
					System.out.println("List of Bank Accounts Numbers of " + customer.getFirstName() + " "
							+ customer.getLastName());
					System.out.println(customer.getBankAccountNumbers());
					return customer.getBankAccountNumbers();
				}

				static void viewOne(Integer bankAccountNumber) {
					System.out.println("Bank Account Number: " + bankAccountNumber);
					System.out.println("Bank Account Balance: " + model.BankAccount.get(bankAccountNumber).getAmount());
				}

				static void deposit(Double amount, Integer bankAccountNumber) {
					if (customer == null) {
						bankAccount = model.BankAccount.get(bankAccountNumber); 
						bankAccount.deposit(amount);
					} else if (userExists && customer.hasBankAccount(bankAccountNumber)) {
						bankAccount = model.BankAccount.get(bankAccountNumber); 
						bankAccount.deposit(amount);
					}
				}

				public static boolean isOverDraft(Double amount, Integer bankAccountNumber) {
					bankAccount = model.BankAccount.get(bankAccountNumber);
					return !bankAccount.notOverdraft(amount);
				}

				static void ifNotOverdraftWithdraw (Double amount, Integer bankAccountNumber) {
					try {
						bankAccount = model.BankAccount.get(bankAccountNumber); /// get bank account from dao
						if (!isOverDraft(amount, bankAccountNumber)) {
							bankAccount.withdraw(amount);
						} else {
							throw new AmountException("Amount requested is above account balance");
						}
					} catch (AmountException e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}
				
				static void ifNotOverdraftTransfer (Double amount, Integer fromBank, Integer toBank) {
					try {
						model.BankAccount bankAccount = model.BankAccount.get(fromBank); /// get bank account from dao
						model.BankAccount bankAccount2 = model.BankAccount.get(toBank); /// get bank account from dao
						if (!isOverDraft(amount, fromBank)) {
							bankAccount.withdraw(amount);
							bankAccount2.deposit(amount);
						} else {
							throw new AmountException("Amount requested is above account balance");
						}
					} catch (AmountException e) {
						e.printStackTrace();
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				
				static void withdraw(Double amount, Integer bankAccountNumber) {
					if (customer == null ) {
						ifNotOverdraftWithdraw (amount, bankAccountNumber);
					}else if (userExists && customer.hasBankAccount(bankAccountNumber)) {
						ifNotOverdraftWithdraw (amount, bankAccountNumber);
					}
				}

				static void transfer(Double amount, Integer fromBank, Integer toBank) {
					if (customer == null) {
						ifNotOverdraftTransfer (amount, fromBank, toBank);
					} else if (userExists && customer.hasBankAccount(fromBank)) {
						ifNotOverdraftTransfer (amount, fromBank, toBank);
					}
				}
			}
		}

	}
	static class Employee {
		static BankAccount bankAccount;// = new model.BankAccount();
		static model.Customer customer;// = new model.Customer();
		static model.Employee employee;// = new model.Employee();

		static class Regular {
			static class Do extends Command.Customer.Existing.Do {
				static boolean isRegularEmployee (String username, String password) {
					if (verify(username, password) && model.Employee.isEmployee(username)) {
						employee = model.Employee.getEmployee(username);
						return !model.Employee.isAdmin(username);
					}
					return false;
				}
				
				static boolean isAdmin (String username) {
					employee = model.Employee.getEmployee(username);
					return model.Employee.isAdmin(username);
				}
				
				protected static void approve(Integer applicationReference) {
					Application.approve(applicationReference);
				}

				protected static void deny(Integer applicationReference) {
					Application.deny(applicationReference);
				}
			}

			static class AbilityTo {
				static class View {
					static class Application {
						void viewOne(Integer applicationReference) {}

						static Set<Integer> viewAll() {
							return model.Application.getAll().keySet();
						}
					}

					static class BankAccount {
						static void viewOne(Integer applicationReference) {
							/// prints out one bankaccount
							System.out.println("Bank Account Number: " + applicationReference);
							System.out.println("Bank Balance: " + model.BankAccount.get(applicationReference).getAmount());

						}
					}

					static class Customer {
						void viewOne(Integer applicationReference) {
							/// prints out one customer
						}

						void viewAll() {

						}
					}
				}
			}
		}

		static class Admin extends Command.Customer.Existing.AbilityTo {

			static class Do extends Command.Employee.Regular.Do {
			}

			static class AbilityTo extends Command.Customer.Existing.AbilityTo {
				static class Bank {
					static Set<Integer> viewAll() {
						return BankAccount.getNumbers();
					}
					static void close(Integer bankAccountReference) {
						model.BankAccount.remove(bankAccountReference);
						boolean hasAccount;
						model.Customer customer;
						for(String username : model.Customer.getAll().keySet()) {
							customer = model.Customer.getCustomer(username);
							hasAccount = customer.hasBankAccount(bankAccountReference);
							if (hasAccount) {
								customer.removeBankAccount(bankAccountReference);
							}
						}
					}
				}
				
				static class Customer {
					static Set<String> viewAll() {
						return model.Customer.getUsernames();
					}
				}

				static class Edit {
					static class Customer {
						static void editInfo(String username, String firstname, String lastname) {
							model.Customer.edit(username, firstname, lastname);
						}
					}
				}
			}
		}
	}
	static class Exit {}
}

