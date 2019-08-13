package main;

import data.db.DBConnector;
import utility.print.Welcome;

public class Life {
	public static void playing() {
		DBConnector.connect();
		Welcome.run();
		Menu.run();
	}
	
	public static void end() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		playing();
	}
}
