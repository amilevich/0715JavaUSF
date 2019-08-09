package com.q18;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteClass concClass = new ConcreteClass();
		String mot = "BURRITOS";
		String allLower = "banana";
		String str = "5";
		System.out.println(mot + " contains uppercase letters: " + concClass.anyUpperCase(mot));
		System.out.println(allLower + " contains uppercase letters: " + concClass.anyUpperCase(allLower));
		
		System.out.println(allLower + " converted to all uppercase letters is: " + concClass.convertLowerCase(allLower));
		
		System.out.print(str + " converted to int is: ");
		concClass.convertToInt(str);
		
		 
	}

}
