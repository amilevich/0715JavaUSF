package com.adminScreen;

import java.util.Scanner;

import com.mainmenu.MainScreen;
import com.uncertainty.Admin;


import dao.AdminCreate;


public class ScreenOfAdmin {
	public void menuBridge() {
		Admin admin = new Admin();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your id.");
		String id = in.nextLine();
		Scanner in2 = new Scanner(System.in);
		System.out.println("Enter your name.");
		String name = in2.nextLine();
		Scanner in3 = new Scanner(System.in);
		System.out.println("Enter your user name.");
		String adminLogin = in3.nextLine();
		Scanner in4 = new Scanner(System.in);
		System.out.println("Enter your password.");
		String adminPassword = in4.nextLine();
		
		
		admin.setId(id);
		admin.setName(name);
		admin.setAdminLogin(adminLogin);
		admin.setAdminPassword(adminPassword);
		
		
		MainScreen.admin.add(admin);
		AdminCreate thing = new AdminCreate();
		thing.addtoDB(admin);
	}
}
