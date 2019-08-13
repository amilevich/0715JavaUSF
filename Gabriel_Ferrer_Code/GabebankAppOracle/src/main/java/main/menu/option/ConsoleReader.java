package main.menu.option;

import main.menu.option.ExceptionHandler;
import utility.QuestionGroup;

public class ConsoleReader {
	public static boolean read(QuestionGroup qg, String toPrint) {
		boolean stopLoop = false;

		do {
			System.out.println(toPrint);
			stopLoop = ExceptionHandler.run( qg );
		} while (!stopLoop);
		return stopLoop;
	}
}
