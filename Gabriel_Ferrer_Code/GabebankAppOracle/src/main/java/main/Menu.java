package main;

import data.db.Questions;

import utility.QuestionGroup;

public class Menu {
	public static Integer nxtgrp;
	public static QuestionGroup qg;
	public static String toPrint = "";

	public static void start(Integer nxtgrp) {
		get( Questions.load(nxtgrp), toPrint);
	}

	public static void get(QuestionGroup qg, String toPrint) {
		Menu.toPrint = "";
		if (qg.optionid.containsValue(0)) {
			/// loop through each field
			main.menu.field.ConsoleReader.read(qg);
			start(nxtgrp);
		} else if (qg.fieldid.containsValue(0)) {
			main.menu.option.ConsoleReader.read(qg, toPrint);
			start(nxtgrp);
		}
	}

	public static void run() {
		nxtgrp = 1;
		start(nxtgrp);
	}
}
