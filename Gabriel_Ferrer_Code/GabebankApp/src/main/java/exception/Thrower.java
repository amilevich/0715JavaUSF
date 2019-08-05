package exception;

import main.*;
import main.Command;
import model.*;
import utility.validator.*;

public class Thrower {
	private static String tempUsername = "";
	
	public static void integerThrower (Integer qaID, Integer choice) throws NotAChoiceException, PersonCountException, BankAccountNotFound {
		if (qaID == 10) {
			Flow.dataCollector.put(  QuestionAnswer.displayFieldString(qaID, 1) , choice.toString());
			if (!BankAccount.exists(choice)) {
				throw new BankAccountNotFound("Enter a bank account number that exists");
			}
		} else if (qaID == 14 && (choice <= 1 || choice > 5)) {
			throw new PersonCountException("Please enter a number from 2 to 5");
		} else if ((qaID == 15 || qaID == 16) && !Application.exists(choice)) {
			throw new NotAChoiceException("Please type a correct and existing Application number");
		} else if ((qaID != 10 && qaID != 14 && qaID != 15 && qaID != 16) 
				&& QuestionAnswer.notFound(qaID, choice)) {
			throw new NotAChoiceException("Please type one of the numbers found on the following choices");
		} 
	}
	
	public static void doubleThrower (Integer qaID, Integer answerID, Double amount) throws AmountException{
		if(( qaID == 5 || qaID == 8) && answerID == 2 && !AmountValidator.isValid(amount)) {
			throw new AmountException("Amount entered is not in 0 to 2 decimal format. Example: 2,222,222,22 or 100.14 or 90");
		}
		
		if(( qaID == 9 || qaID == 10) && answerID == 2 && (!AmountValidator.isValid(amount) 
				|| Command.Customer.Existing.AbilityTo.isOverDraft(amount, Flow.openBankAccount))) {
			
			throw new AmountException("Amount requested over available balance or amount not in 2 decimal format");
		}
		Flow.dataCollector.put(   QuestionAnswer.displayFieldString(qaID, answerID) , amount.toString());
	}
	public static void stringThrower (Integer qaID, Integer answerID, String string) 
			throws CurrencyException, LetterOnlyException, UsernameInvalidException,
			    UsernameExistsException, UserAccountNotFound, PasswordInvalidException {

		if(qaID == 5 && answerID == 2 && (!string.equalsIgnoreCase("USD") && !string.equalsIgnoreCase("EUR"))) {
			throw new CurrencyException("Please type EUR or USD");
		}

		if((qaID == 6 || qaID == 19) && (answerID >= 1 && answerID <= 2) && !Validator.onlyLetters(string)) {
			throw new LetterOnlyException("Type letters only!");
		}

		if( qaID == 6 && (answerID == 3)  && !UsernameValidator.isValid(string.toLowerCase())) {
			throw new UsernameInvalidException("Username/Password is invalid. ");
		}

		if(  qaID == 6 && (answerID == 3) && UserAccount.exists(string.toLowerCase()) ) {
			throw new UsernameExistsException("Username already exists. Please type another username");   // for registration
		}
//		} else if (  qaID == 3 && (answerID == 1) && UserAccount.exists(string.toLowerCase()) ) {
//			throw new UsernameExistsException();  // for existing accounts
//		}
		
		if(qaID == 6 && (answerID == 4) && !PasswordValidator.isValid(string)  ) {
			throw new PasswordInvalidException("Username/Password is invalid. ");
		}
		
		if(qaID == 3 && (answerID == 1) && !UserAccount.exists(string)) {
			throw new UserAccountNotFound("User account is not found, your application was not yet approved or your application was denied");
		}
		
		if(qaID == 3 && answerID == 2 && !UserAccount.exists(tempUsername, string)  ) {
			throw new PasswordInvalidException();
		}
		tempUsername = string;
		Flow.dataCollector.put(  QuestionAnswer.displayFieldString(qaID, answerID)    , string);
	}
}
