package bankapp;

//package items;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Menus.MainMenu;

public class FirstLogin2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        	MainMenu.LoginMenu();//LoginMenu is to help keep files in real time
		try {
			PendingApplication.deserialize();
			ApprovedApplication.deserialize();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			//MainMenu.LoginMenu();
			MainMenu.mainMenu();
		}
		ApprovedApplication.serializeAll(); 
	}  

}