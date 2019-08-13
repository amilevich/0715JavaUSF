package com.bankdb.project;

public class VerifyNumberTwo {
	public boolean verifyNum(String c) {		
		if(c.matches("[0-9.]+")) {
			return true;
		}else {
			return false;
		}		
	}
}
