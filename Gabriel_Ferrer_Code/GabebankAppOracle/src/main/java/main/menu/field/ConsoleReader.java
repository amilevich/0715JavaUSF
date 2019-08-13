package main.menu.field;

import main.Menu;
import utility.QuestionGroup;

public class ConsoleReader {
	public static boolean read(QuestionGroup qg) {
		boolean stopLoop = false;
		Integer akForNextGroup = 0;
		for (Integer answerkey : qg.fieldid.keySet()) {
			akForNextGroup = answerkey;
			do {
				System.out.println(qg.question.get(answerkey));
				stopLoop = ExceptionHandler.run(qg, qg.scantype.get(answerkey), answerkey);
			} while (!stopLoop);
		}
		Menu.nxtgrp = qg.getNextGroupIDByAnswerKey(akForNextGroup);
		return stopLoop;

	}
}
