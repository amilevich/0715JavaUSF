package com.qeighteen;

//q18: inheritance of abstract methods
public class Main {

	public static void main(String[] args) {
		// initialize the string and subclass
		String string = "Devon James Virden";
		SubClass sub = new SubClass();
		// print it all out
		System.out.println("String:\t\t" + string);
		System.out.println("Has Uppercase:\t" + sub.upperCase(string));
		System.out.println("To Uppercase:\t" + sub.toUpperCase(string));
		System.out.println("To int + 10:\t" + sub.toIntPlus10(string));
	}

}
