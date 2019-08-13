package main.menu.option;

import java.util.Scanner;

import exception.NotAChoiceException;
import utility.QuestionGroup;
import main.Actions;
import main.Form;
import main.Menu;

public class Thrower {
	public static boolean getInteger(QuestionGroup qg) throws 
	NotAChoiceException {
		Scanner sc = new Scanner(System.in);
		Integer optionid = 0;
		optionid = sc.nextInt();

		if (!qg.optionid.containsValue(optionid)) {
			throw new NotAChoiceException("Number not among the choices");
		}
		
		Menu.nxtgrp = qg.getNextGroupID(optionid);
		Integer answerkey = qg.getAnswerKeyByOptionID(optionid); 
		Form.saveAnswer(answerkey, "1");
		Actions.run(answerkey);
		
		return true;
	}
}
