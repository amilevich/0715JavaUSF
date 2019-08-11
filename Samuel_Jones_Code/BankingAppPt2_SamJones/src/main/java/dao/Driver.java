package dao;

import beans.Account;
import beans.User;
import menus.MainMenu;

public class Driver {
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.firstLoginMenu();
	}
}
