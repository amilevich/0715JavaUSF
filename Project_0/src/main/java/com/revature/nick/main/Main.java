package com.revature.nick.main;

import com.revature.nick.data.UserData;
import com.revature.nick.database.CustomerDAO;
import com.revature.nick.database.UserDAO;
import com.revature.nick.model.Customer;
import com.revature.nick.model.User;
import com.revature.nick.views.ViewController;

public class Main {

	public static void main(String[] args) 
	{
		UserData user = new UserData(1,"Nick", "password","customer");
		UserDAO dao = new UserDAO();
		dao.insert(user);
		ViewController controller = ViewController.getInstance();
		controller.start();
	}

}
