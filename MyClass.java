package com.example.exception;

public class MyClass {

	public static void main(String[] args) {
		bankTransaction("Withdraw", 100);
		System.out.println("done");
	}
	
	public static void bankTransaction(String action, double amount) {
		if(action.equals("Withdraw")) {
			try {
				withdraw(amount);
			} catch (WithdrawTooBigException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("*******in finally block, woo*******");
			}
		}
	}
	
	public static void withdraw(double withdrawAmount) throws WithdrawTooBigException {
		double maxWithdrawAmount = 10000;
		if(withdrawAmount > maxWithdrawAmount) {
			throw new WithdrawTooBigException(withdrawAmount + " exceeds"
					+ " the max withdraw limit of: " + maxWithdrawAmount);
		}
	}

}
