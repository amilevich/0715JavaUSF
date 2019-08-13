package main.menu.field;

import org.apache.log4j.Logger;
import data.dao.*;
import exception.*;
import main.*;
import model.*;
import utility.*;
import utility.ds.MapOps;
import utility.validator.*;

public class Thrower {
	final static Logger logger = Logger.getLogger(Thrower.class);
	
	public static ApplicantsDAOI appldao = new ApplicantsDAOI();
	private static BankAccountDAOI bankdao = new BankAccountDAOI();
	private static CustomerDAOI custdao = new CustomerDAOI();
	private static EmployeeDAOI empdao = new EmployeeDAOI();
	private static UserAccountDAOI userdao = new UserAccountDAOI();

	private static BankAccount bankAccount = new BankAccount();
	private static Customer customer = new Customer();
	private static Employee employee = new Employee();
	private static UserAccount useraccount = new UserAccount();

	public static boolean getDouble(QuestionGroup qg, Double amount, Integer answerkey) throws AmountException {
		switch (answerkey) {   
			case 36:     /// case for withdrawal
			case 39:     /// case for transfer
			case 47:     /// case for withdrawal
			case 50:     /// case for transfer
				if (!AmountValidator.isValid(amount)) {
					throw new AmountException(
							"Amount entered is not in 0 to 2 decimal format. " + "Example: 2,222,222,222 or 100.14 or 90");
				} else {
					if (  Actions.origBankAcct.isOverdraft(amount)  ) {
						throw new AmountException("Amount requested over available balance");
					}
				}
				break;
			default:     /// cases for deposit amounts only
				if (!AmountValidator.isValid(amount)) {
					throw new AmountException(
							"Amount entered is not in 0 to 2 decimal format. " + "Example: 2,222,222,222 or 100.14 or 90");
				}
				break;
		}
		Form.saveAnswer(answerkey, amount.toString());
		Actions.run(answerkey);
		return true;
	}

	public static boolean getInteger(QuestionGroup qg, Integer choice, Integer answerkey)
			throws NotAChoiceException, PersonCountException, BankAccountNotFound {
		boolean isApplication = MapOps.match("app", answerkey);
		boolean isBankAccountCustomer = MapOps.match("bac", answerkey);
		boolean isBankAccountAdmin = MapOps.match("baa", answerkey);
		boolean isJointSize = MapOps.match("jn", answerkey);
		
		if (isApplication) {
			if (!All.appss.contains(choice)) {
				throw new NotAChoiceException("Please type an open, correct and/or existing Application number");
			}
		} else if (isBankAccountCustomer) {
			bankAccount = bankdao.getOne( Actions.customer.getBankAccountNumber()  );
			if (bankAccount != null) {
				if (bankdao.getOneCurrencyMatch(choice, bankAccount.getCurrency()) == null) {
					throw new NotAChoiceException(
							"Please type a Bank Account Number with the " + bankAccount.getCurrency() + " currency");
				}
			} else {
				throw new NotAChoiceException("Please type a correct and existing Bank account number");
			}
		} else if (isBankAccountAdmin) {
			if (!All.bass.contains(choice)) {
				throw new NotAChoiceException("Please type a correct and existing Bank account number with the same currency.\n"
						+ "Recipient Account Number should not match the Source Account Number.");
			}
		} else if (isJointSize) {
			if (choice <= 1 || choice > 5) {
				throw new PersonCountException("Please enter a number from 2 to 5");
			}
		}

		Form.saveAnswer(answerkey, choice.toString());
		Actions.run(answerkey);
		return true;
	}

	public static boolean getString(QuestionGroup qg, String string, Integer answerkey)
			throws CurrencyException, LetterOnlyException, UsernameInvalidException, UsernameExistsException,
			UserAccountNotFound, PasswordInvalidException {
		boolean isCurrency = MapOps.match("currency", answerkey);
		boolean isName = MapOps.match("name", answerkey);
		boolean isOldUsername = MapOps.match("oun", answerkey);
		boolean isNewUsername = MapOps.match("nun", answerkey);
		boolean isPassword = MapOps.match("pw", answerkey);
		boolean isCustomerLogin = MapOps.match("cust", answerkey);
		boolean isRegEmpLogin = MapOps.match("reg", answerkey);
		boolean isAdminEmpLogin = MapOps.match("adm", answerkey);
		boolean isForCustomerEdit = MapOps.match("custe", answerkey);

		if (isCurrency && !ValueValidator.isCurrencyValid(string)) {
			throw new CurrencyException("Please type EUR or USD");
		}
		if (isName && !Validator.onlyLetters(string)) {
			throw new LetterOnlyException("Type letters only!");
		}
		if (isOldUsername) {
			boolean inexistentUser;
			boolean notACustomer;
			boolean notEmployee;

			if (isPassword) {
				inexistentUser = useraccount == null;
				if (!inexistentUser && !useraccount.getPassword().equals(string)) {
					throw new PasswordInvalidException("Password doesn't match our records");
				} else if (!inexistentUser) {
					if (isCustomerLogin) {
						customer = custdao.getOne( useraccount.getUsername() );
						notACustomer = customer == null;
						if (notACustomer) {
							System.out.println("User not a customer");
							Menu.start(1);
						} else {
							Actions.customer = customer;
							logger.info( String.format("Username %1$s successfully logged in", customer.getUsername()) );
						}
					}
					if (isRegEmpLogin) {
						employee = empdao.getOne(useraccount.getUsername());
						notEmployee = employee == null;
						if (notEmployee) {
							System.out.println("User not a regular employee");
							Menu.start(1);
						} else if (!notEmployee && employee.getIsAdmin()) {
							System.out.println("User not a regular employee");
							Menu.start(1);
						} else {
							logger.info( String.format("Username %1$s successfully logged in", employee.getUsername()) );
						}
					}
					if (isAdminEmpLogin) {
						employee = empdao.getOne( useraccount.getUsername() );
						notEmployee = employee == null;
						if (notEmployee) {
							System.out.println("User not an admin employee");
							Menu.start(1);
						} else if (!notEmployee && !employee.getIsAdmin()) {
							System.out.println("User not an admin employee");
							Menu.start(1);
						} else {
							logger.info( String.format("Username %1$s successfully logged in", employee.getUsername()) );
						}
					}

				}
			} else {
				useraccount = userdao.getOne(string.toLowerCase());
				inexistentUser = useraccount == null;
				if (inexistentUser) {
					throw new UsernameExistsException("Please type an existing username");
				} else {
					if (isForCustomerEdit) {
						if( !All.custss.contains( string ) ) {
							throw new UsernameExistsException("Please provide a username that a customer uses");
						}
					}
				}
			}

		}

		if (isNewUsername) {
			UserAccount useraccount = userdao.getOne(string.toLowerCase());
			Applicant userApplicant = appldao.getOne(string.toLowerCase());
			boolean userApplicantExists = userApplicant != null;
			boolean userExists = useraccount != null;

			if (isPassword) {
				if (!PasswordValidator.isValid(string)) {
					throw new PasswordInvalidException("Password is invalid");
				}
			} else {
				if (userExists || userApplicantExists || Form.userTaken(string.toLowerCase())) {
					throw new UsernameExistsException("Username already exists. Please type another username");
				}
				if (!UsernameValidator.isValid(string.toLowerCase())) {
					throw new UsernameInvalidException("Username is invalid");
				}
			}
		}
		Form.saveAnswer(answerkey, string);
		Actions.run(answerkey);
		return true;
	}
}
