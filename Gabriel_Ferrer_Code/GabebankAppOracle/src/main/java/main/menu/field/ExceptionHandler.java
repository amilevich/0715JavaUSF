package main.menu.field;

import java.util.Scanner;

import exception.AmountException;
import exception.BankAccountNotFound;
import exception.CurrencyException;
import exception.LetterOnlyException;
import exception.NotAChoiceException;
import exception.PasswordInvalidException;
import exception.PersonCountException;
import exception.UserAccountNotFound;
import exception.UsernameExistsException;
import exception.UsernameInvalidException;
import utility.QuestionGroup;

public class ExceptionHandler {
	public static boolean run(QuestionGroup qg, String scantype, Integer answerkey) {
		Integer choice;
		Double amount;
		String string;
		boolean stopLoop = false;
		try {
			Scanner sc = new Scanner(System.in);

			if ( scantype.equals("integer") ) {
				choice = sc.nextInt();
				Thrower.getInteger( qg, choice, answerkey);
			} else if (  scantype.equals("double")  ) {
				amount = sc.nextDouble();
				Thrower.getDouble( qg, amount, answerkey);
			} else if (  scantype.equals("string")  ) {
				string = sc.nextLine();
				Thrower.getString( qg, string, answerkey);
			} 
			stopLoop = true;
		} catch (AmountException| PersonCountException | BankAccountNotFound | UserAccountNotFound e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} catch (PasswordInvalidException | UsernameInvalidException e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} catch (UsernameExistsException e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} catch (LetterOnlyException e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} catch (CurrencyException e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} catch (NotAChoiceException e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Please enter the correct type");
			stopLoop = false;
		} 
		
		return stopLoop;
	}
}
