package utility;

import java.util.Scanner;
import java.util.Set;

import exception.AmountException;
import exception.BankAccountNotFound;
import exception.CurrencyException;
import exception.LetterOnlyException;
import exception.NotAChoiceException;
import exception.PasswordInvalidException;
import exception.PersonCountException;
import exception.Thrower;
import exception.UserAccountNotFound;
import exception.UsernameExistsException;
import exception.UsernameInvalidException;
import model.QuestionAnswer;

import static main.Flow.readType;
import static main.Flow.choice;
import static main.Flow.amount;
import static main.Flow.string;
import static main.Flow.isAdmin;


public class ConsoleReader {
	public static boolean printf = false;
    public static String consoleStringSetReader (Set<String> setChoices, String message) {
		boolean continueLoop = true;
		String usernameSelected = "";
		
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(message);
			try {
				usernameSelected = sc.nextLine();
				if (!setChoices.contains(usernameSelected) && message.equals("Please type customer username to edit that customer info.")) {
					throw new NotAChoiceException("Customer not found");
				}
			} catch (NotAChoiceException e) {
				System.out.println(e.getMessage());
				continueLoop = true;
				continue;
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Please enter the correct type");
				continueLoop = true;
				continue;
			}
			continueLoop = false;
		} while (continueLoop);
		
		return usernameSelected;
	}
	
	public static Integer consoleIntegerSetReader(Set<Integer> setChoices, String message) {
		boolean continueLoop = true;
		Integer acctSelected = 0;

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(message);
			try {
				acctSelected = sc.nextInt();
				if (!setChoices.contains(acctSelected) && message.equals("Please type the bank account.")) {
					throw new NotAChoiceException("Bank Account not found");
				} else if (!setChoices.contains(acctSelected)
						&& message.equals("Please type an open application number.")) {
					throw new NotAChoiceException("Application not found");
				}
			} catch (NotAChoiceException e) {
				System.out.println(e.getMessage());
				continueLoop = true;
				continue;
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Please enter the correct type");
				continueLoop = true;
				continue;
			}
			continueLoop = false;
		} while (continueLoop);
		return acctSelected;
	}
	
	public static void consoleFieldReader(Integer qaID, String str) {
		System.out.printf(QuestionAnswer.displayQuestion(qaID), str);
		printf = true;
		consoleFieldReader(qaID);
	}
	
	public static void consoleFieldReader(Integer qaID) {
		boolean continueLoop = true;
		Integer fieldsCount = QuestionAnswer.getNumberOfFields(qaID);
		String question = printf ? "" : QuestionAnswer.displayQuestion(qaID);
		if (fieldsCount == 1) {
			System.out.println(question);
			do {
				Scanner sc = new Scanner(System.in);
				readType = QuestionAnswer.displayField(qaID);
				try {
					if (readType == 1) {
						choice = sc.nextInt();
						Thrower.integerThrower(qaID, choice);
					} else if (readType == 2) {
						amount = sc.nextDouble();
						Thrower.doubleThrower(qaID, 2, amount);
					} else if (readType == 3) {
						string = sc.nextLine();
						Thrower.stringThrower(qaID, 1, string);
					}
					continueLoop = false;
				} catch (AmountException e) {
					System.out.println(e.getMessage());
					continueLoop = true;
					continue;
				} catch (PersonCountException e) {
					System.out.println(e.getMessage());
					continueLoop = true;
					continue;
				} catch (Exception e) {
//					e.printStackTrace();
					System.out.println("Please enter the correct type");
					continueLoop = true;
					continue;
				}
			} while (continueLoop);
		} else {
			System.out.println(question);
			for (Integer i = 1; i <= fieldsCount; ++i) {
				do {
					Scanner sc = new Scanner(System.in);
					readType = QuestionAnswer.displayField(qaID, i);
					try {
						if (readType == 1) {
							choice = sc.nextInt();
							Thrower.integerThrower(qaID, choice);
						} else if (readType == 2) {
							amount = sc.nextDouble();
							Thrower.doubleThrower(qaID, i, amount);
						} else if (readType == 3) {
							string = sc.nextLine();
							Thrower.stringThrower(qaID, i, string);
						}
						continueLoop = false;
					} catch (BankAccountNotFound e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (UserAccountNotFound e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (AmountException e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (PasswordInvalidException | UsernameInvalidException e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (UsernameExistsException e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (LetterOnlyException e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (CurrencyException e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (NotAChoiceException e) {
						System.out.println(e.getMessage());
						continueLoop = true;
						continue;
					} catch (Exception e) {
//						e.printStackTrace();
						System.out.println("Please enter the correct type");
						continueLoop = true;
						continue;
					}
				} while (continueLoop);
			}
		}

	}

	public static void consoleOptionReader(Integer qaID) {
		boolean continueLoop = true;
		do {
			Scanner sc = new Scanner(System.in);
			String concat = QuestionAnswer.displayQuestion(qaID) + "\n" + QuestionAnswer.displayChoices(qaID);
			System.out.println(concat);
			try {
				if (readType == 1) {
					choice = sc.nextInt();
					Thrower.integerThrower(qaID, choice);
				} else if (readType == 2) {
					amount = sc.nextDouble();
				} else if (readType == 3) {
					string = sc.nextLine();
				}
				continueLoop = false;
			} catch (NotAChoiceException e) {
				System.out.println(e.getMessage());
				continueLoop = true;
				continue;
			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("Please enter the correct type");
				continueLoop = true;
				continue;
			}
		} while (continueLoop);

	}

}
