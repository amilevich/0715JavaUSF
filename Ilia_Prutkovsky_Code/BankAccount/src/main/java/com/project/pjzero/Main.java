package com.project.pjzero;

import java.io.FileNotFoundException;

public class Main extends Menu {

	public static void main(String[] args) throws FileNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Menu menu = new Menu();		
		menu.mainMenu();
	}
}