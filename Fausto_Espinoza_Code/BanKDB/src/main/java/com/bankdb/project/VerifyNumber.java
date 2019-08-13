package com.bankdb.project;

public class VerifyNumber {
	
	public boolean verifyNum(long count, String c) {
		String option = new String();
		long number  = 0;
		boolean flag = true ;
		char y[] = c.toCharArray();
		int size = y.length;
		
		int i = 0;
		while(i != size) {
			if(y[i] >= '0' && y[i] <= '9') {
				option += y[i];
				++i;
				flag = true;
			}else {
				System.out.println("No is a valid option");
				option = "";
				flag = false;
				break;
			}
		}
		if(flag) {
			number = Long.parseLong(option);
		}
		if(number <= 0 || number > count || !flag) {
			flag = false;
		}
		return flag;
	}

}
