package main.menu.option;

import exception.NotAChoiceException;
import utility.QuestionGroup;

public class ExceptionHandler {
	public static boolean run(QuestionGroup qg) {
		boolean stopLoop = false;
		try {
			stopLoop = Thrower.getInteger(qg);
			stopLoop = true;
		} catch (NotAChoiceException e) {
			System.out.println(e.getMessage());
			stopLoop = false;
		} 
		catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Input not among the choices");
			stopLoop = false;
		}

		return stopLoop;
	}
}
