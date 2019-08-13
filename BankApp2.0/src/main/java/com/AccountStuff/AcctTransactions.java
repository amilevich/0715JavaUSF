package com.AccountStuff;

import java.util.Scanner;

public class AcctTransactions {
	
	static double balance = 0.0;
	
	public static void myDeposit(int x) {
		double y = x;
		balance = balance + y; 
		System.out.println("You just deposited "+ " "+ "$"+y );
		System.out.println("Your current Balance is "+" "+"$"+balance);
		
	}
	
//	public static void main(String[] args) {
//		//myDeposit(100);
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the amount you'd like to deposit");
//		int amount = sc.nextInt();
//		myDeposit(amount);
//	}

	public static void myWithdraw(int y) {
		balance = balance - y;
		if(y > balance) {
			System.out.println("You have insufficient funds!!");
		}else {
		System.out.println("You just withdrew "+ " "+ "$"+y );
		System.out.println("Your current Balance is "+" "+"$"+balance);
		}
		
	}
}
