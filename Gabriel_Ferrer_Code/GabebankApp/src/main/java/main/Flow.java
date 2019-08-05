package main;

import java.util.TreeMap;

import org.apache.log4j.Logger;

import seed.QuestionAnswers;
import value.Currency;
import seed.PrimaryModels;

import model.Customer;
import model.QuestionAnswer;
import utility.*;

import static main.Command.Customer.Existing;
import static main.Command.Customer.Existing.AbilityTo;
import static main.Command.Customer.New.*;
import static main.Command.Employee.Regular;
import static main.Command.Employee.Admin;
import static utility.ConsoleReader.*;

public class Flow {
	public static Integer readType;
	public static Integer choice = -1; // 1
	public static Double amount = 0.0; // 2
	public static String string = ""; // 3
	public static Integer isAdmin = 0;
	public static Integer openBankAccount = 0;
	public static Integer applicationNumber = 0;
	public static String username = "";
	public static TreeMap<String, String> dataCollector = new TreeMap<String, String>();
	final static Logger logger = Logger.getLogger(Flow.class);

	static class Transaction {
		static void run() {
			if (QuestionAnswer.nextQuestion(7, choice) == 8) { /// deposit
				consoleFieldReader(8);
				AbilityTo.deposit(amount, openBankAccount);
				AbilityTo.viewOne(openBankAccount); /// throws exception if not found
			} else if (QuestionAnswer.nextQuestion(7, choice) == 9) { /// withdraw
				consoleFieldReader(9);
				AbilityTo.withdraw(amount, openBankAccount);
				AbilityTo.viewOne(openBankAccount); /// throws exception if not found
			} else if (QuestionAnswer.nextQuestion(7, choice) == 10) { /// transfer
				consoleFieldReader(10);
				System.out.println(dataCollector);
				Integer recipient = Integer
						.valueOf(dataCollector.get("Recipient Bank Account Number (Number with no leading zeros)"));
				AbilityTo.transfer(amount, openBankAccount, recipient);
				AbilityTo.viewOne(openBankAccount);
				AbilityTo.viewOne(recipient);
			}
		}
	}

	public static void run() {
		consoleFieldReader(18);
		consoleOptionReader(1);
		if (QuestionAnswer.nextQuestion(1, choice) == 2) { /// customer
			consoleOptionReader(2);
			if (QuestionAnswer.nextQuestion(2, choice) == 4) { /// new
				consoleOptionReader(4);
				if (QuestionAnswer.nextQuestion(4, choice) == 5 && choice == 1) { /// individual
					consoleFieldReader(5);
					Individual.addAccountDetail(amount, Currency.valueOf(string.toUpperCase()));
					consoleFieldReader(6);
					Individual.addApplicant(dataCollector.get("Firstname (Text without Numbers or Special Characters)"),
							dataCollector.get("Lastname (Text without Numbers or Special Characters)"),
							dataCollector.get(
									"Username (Text that has at least 5 letters of chracters or numbers without Special Characters.\n It must start with a letter)"),
							dataCollector.get(
									"Password (Text with at least 8 characters, has at least one number, \none lowercase, one uppercase and one special character)"));
					Individual.apply();
					dataCollector = new TreeMap<String, String>();
					choice = -1;
				} else if (QuestionAnswer.nextQuestion(4, choice) == 14 && choice == 2) { /// joint
					consoleFieldReader(14);
					consoleFieldReader(5);
					Joint.addAccountDetail(amount, Currency.valueOf(string.toUpperCase()));
					for (Integer i = choice; i >= 1; i--) {
						consoleFieldReader(6);
						Joint.addApplicant(dataCollector.get("Firstname (Text without Numbers or Special Characters)"),
								dataCollector.get("Lastname (Text without Numbers or Special Characters)"),
								dataCollector.get(
										"Username (Text that has at least 5 letters of chracters or numbers without Special Characters.\n It must start with a letter)"),
								dataCollector.get(
										"Password (Text with at least 8 characters, has at least one number, \none lowercase, one uppercase and one special character)"));
					}
					Joint.apply();
					dataCollector = new TreeMap<String, String>();
					choice = -1;
				}
			} else if (QuestionAnswer.nextQuestion(2, choice) == 3) { /// existing
				consoleFieldReader(3);
				readType = 1;
				Existing.Do.verify(dataCollector.get("Username"), dataCollector.get("Password"));
				logger.info(String.format("Customer username %1$s successfully logged in", dataCollector.get("Username")));
				openBankAccount = consoleIntegerSetReader(AbilityTo.viewAll(),
						"Please type the bank account you like to make a transaction.");
				AbilityTo.viewOne(openBankAccount);
				consoleOptionReader(7);
				Transaction.run();
			}

		} else if (QuestionAnswer.nextQuestion(1, choice) == 3) { /// employee
			consoleFieldReader(3);
			readType = 1;
			if (Regular.Do.isRegularEmployee(dataCollector.get("Username"), dataCollector.get("Password"))) { /// regular
				logger.info(String.format("Regular Employee username %1$s successfully logged in", dataCollector.get("Username")));
				consoleOptionReader(11);
				if (QuestionAnswer.nextQuestion(11, choice) == 15) { /// approve an open application
					PrintTable.displayApplications();
					applicationNumber = consoleIntegerSetReader(Regular.AbilityTo.View.Application.viewAll(),
							"Please type an open application number.");
					Regular.Do.approve(applicationNumber);
				} else if (QuestionAnswer.nextQuestion(11, choice) == 16) { /// reject an open application
					PrintTable.displayApplications();
					applicationNumber = consoleIntegerSetReader(Regular.AbilityTo.View.Application.viewAll(),
							"Please type an open application number.");
					Regular.Do.deny(applicationNumber);
				} else if (QuestionAnswer.nextQuestion(11, choice) == 3) { /// view customers
					PrintTable.displayCustomers();
				} else if (QuestionAnswer.nextQuestion(11, choice) == 4) { /// view accounts
					PrintTable.displayAccounts();
				}
			} else if (Regular.Do.isAdmin(dataCollector.get("Username"))) { /// admin
				logger.info(String.format("Admin Employee username %1$s successfully logged in", dataCollector.get("Username")));
				consoleOptionReader(12);
				if (QuestionAnswer.nextQuestion(12, choice) == 15) {
					PrintTable.displayApplications();
					applicationNumber = consoleIntegerSetReader(Regular.AbilityTo.View.Application.viewAll(),
							"Please type an open application number.");
					Admin.Do.approve(applicationNumber);
				} else if (QuestionAnswer.nextQuestion(12, choice) == 16) {
					PrintTable.displayApplications();
					applicationNumber = consoleIntegerSetReader(Regular.AbilityTo.View.Application.viewAll(),
							"Please type an open application number.");
					Admin.Do.deny(applicationNumber);
				} else if (QuestionAnswer.nextQuestion(12, choice) == 3) {
					PrintTable.displayCustomers();
				} else if (QuestionAnswer.nextQuestion(12, choice) == 4) { /// view accounts
					PrintTable.displayAccounts();
				} else if (QuestionAnswer.nextQuestion(12, choice) == 7) {
					consoleOptionReader(7);
					openBankAccount = consoleIntegerSetReader(Admin.AbilityTo.Bank.viewAll(), "Please type the bank account.");
					Transaction.run();
				} else if (QuestionAnswer.nextQuestion(12, choice) == 13) {
					PrintTable.displayAccounts();
					openBankAccount = consoleIntegerSetReader(Admin.AbilityTo.Bank.viewAll(), "Please type the bank account.");
					Admin.AbilityTo.Bank.close(openBankAccount);
				} else if (QuestionAnswer.nextQuestion(12, choice) == 19) {
					PrintTable.displayCustomers();
					username = consoleStringSetReader(Admin.AbilityTo.Customer.viewAll(), "Please type customer username to edit that customer info.");
					consoleFieldReader(19, Customer.getCustomer(username).getFullname());
					Admin.AbilityTo.Edit.Customer.editInfo(username, dataCollector.get("Firstname (Text without Numbers or Special Characters)"),
							dataCollector.get("Lastname (Text without Numbers or Special Characters)"));
				}
			} else {
				System.out.println("Sorry but you are not an employee of this bank");
				System.out.println("Access denied!");
			}

		} else if (choice == 3) { /// exit
			System.out.println("Thank you for having a great experience with GABEBANK. Have a wonderful day!!");
			Life.end();
		}
	}

	public static void main() {
		QuestionAnswers.seed();

		Flow.dataCollector = new TreeMap<String, String>();

		while (choice != 0) {
			choice = -1;
			readType = 1;
			run();
		}
	}
}
