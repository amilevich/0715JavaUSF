package seed;

import java.util.TreeMap;

import main.*;
import model.Answer;
import model.QuestionAnswer;

public class QuestionAnswers {
	public static void seed() {
		TreeMap<Integer,Answer> answers = new TreeMap<Integer, Answer>();
		/////////// Always press zero to exit
		new QuestionAnswer(1, "Are you a Customer or Employee?", answers);
		answers.put(1, new Answer(2,"Press 1 and enter for Customer"));
		answers.put(2, new Answer(3,"Press 2 and enter for Employee"));
		answers.put(3, new Answer(0,"Press 3 and enter to Exit"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(2, "Are you a new or existing customer?", answers);
		answers.put(1, new Answer(4,"Press 1 and enter for new customer"));
		answers.put(2, new Answer(3,"Press 2 and enter for existing customer"));
		answers = new TreeMap<Integer, Answer>();

		new QuestionAnswer(3, "What is your user login info?", answers);
		answers.put(1, new Answer(3,"Username"));
		answers.put(2, new Answer(3,"Password"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(4, "Are you applying for an Individual or Joint Account?", answers);
		answers.put(1, new Answer(5,"Press 1 and enter for individual account"));
		answers.put(2, new Answer(14,"Press 2 and enter for joint account"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(5 , "Please provide for your Bank Account information", answers );
		answers.put(2, new Answer(2, "Amount to Deposit (Amount with Two Decimals)") );
		answers.put(1, new Answer(3, "Currency (Type EUR or USD then press enter)") );
		answers = new TreeMap<Integer, Answer>();

		new QuestionAnswer(6 , "Please provide for your Personal information", answers );
		answers.put(1, new Answer(3, "Firstname (Text without Numbers or Special Characters)") );
		answers.put(2, new Answer(3, "Lastname (Text without Numbers or Special Characters)") );
		answers.put(3, new Answer(3, "Username (Text that has at least 5 letters of chracters or numbers without Special Characters.\n It must start with a letter)") );
		answers.put(4, new Answer(3, "Password (Text with at least 8 characters, has at least one number, \none lowercase, one uppercase and one special character)"));
		answers = new TreeMap<Integer, Answer>();

		new QuestionAnswer(7 , "What would you like to do with the account?", answers );
		answers.put(1, new Answer(8, "Press 1 and enter for Deposit money"));
		answers.put(2, new Answer(9, "Press 2 and enter for Withdraw money"));
		answers.put(3, new Answer(10, "Press 3 and enter for Transfer money from one account to another"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(8, "Amount to Deposit  (Amount with Two Decimals)", answers );
		//answers.put(1, new Answer(1, "Bank Account Number (Number with no leading zeros)"));
		answers.put(2, new Answer(2, "Amount to Deposit"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(9 , "Amount to Withdraw  (Amount with Two Decimals)", answers );
		//answers.put(1, new Answer(1, "Bank Account Number (Number with no leading zeros)"));
		answers.put(2, new Answer(2, "Account Number to Withdraw"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(10 , "Provide Transfer details", answers );
		answers.put(1, new Answer(1, "Recipient Bank Account Number (Number with no leading zeros)"));
		answers.put(2, new Answer(2, "Amount to Transfer (Amount with Two Decimals)"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(11 , "As a regular employee you can do the following duties?", answers );
		answers.put(1, new Answer(15, "Press 1 and enter to approve an open application"));
		answers.put(2, new Answer(16, "Press 2 and enter to reject an open application"));
		answers.put(3, new Answer(3, "Press 3 and enter to view all customers details"));
		answers.put(4, new Answer(4, "Press 4 and enter to view all account details"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(12 , "As an admin employee you can do the following duties?", answers );
		answers.put(1, new Answer(15, "Press 1 and enter to approve an open application"));
		answers.put(2, new Answer(16, "Press 2 and enter to reject an open application"));
		answers.put(3, new Answer(3, "Press 3 and enter to view all customers details"));
		answers.put(4, new Answer(4, "Press 4 and enter to view all account details"));
		answers.put(5, new Answer(7, "Press 5 and enter to deposit, withdraw or transfer money"));
		answers.put(6, new Answer(13, "Press 6 and enter to close bank account"));
		answers.put(7, new Answer(19, "Press 7 and enter to edit customer info"));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(13 , "Bank Account Number (Number with no leading zeros) to close", answers );
		answers.put(1, new Answer(1, null));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(14, "How many people do you want to associate\n with the joint account? Minimum 2, Maximum 5", answers);
		answers.put(1, new Answer(1, null));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(15, "Enter Application Number to accept (Number with no leading zeros)		", answers);
		answers.put(1, new Answer(1, null));
		answers = new TreeMap<Integer, Answer>();
		
		new QuestionAnswer(16, "Enter Application Number to reject (Number with no leading zeros)		", answers);
		answers.put(1, new Answer(1, null));
		answers = new TreeMap<Integer, Answer>(); 
		
		new QuestionAnswer(17, "Thank you for your time! Happy to serve you!", answers);
		answers.put(1, new Answer(1, null));
		answers = new TreeMap<Integer, Answer>(); 

		new QuestionAnswer(18, "€€*****Welcome to GABEBANK*****$$", answers);
		//answers.put(1, new Answer(1, null));
		answers = new TreeMap<Integer, Answer>(); 
		
		new QuestionAnswer(19 , "Your original name is %s%n . Please provide fields to edit original.", answers );
		answers.put(1, new Answer(3, "Firstname (Text without Numbers or Special Characters)") );
		answers.put(2, new Answer(3, "Lastname (Text without Numbers or Special Characters)") );
		
	}
}
