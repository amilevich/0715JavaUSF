package com.question18.concretesubclass;

//Testing Class
public class MainDriver {

	//Main Method
	public static void main(String[] args) {
		
		String s = "hEllo";
		
		TooEasyWork j = new TooEasyWork();
		
		System.out.println(j.upperCaseCheck(s));
		System.out.println(j.conversion(s));
		System.out.println(j.toInteger(s));

	}

}
