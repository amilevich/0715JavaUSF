package homework.question.q18.main;

import homework.question.q18.*;

public class ImplementingAbstractMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClass subClass = new SubClass();
		String testString = "&Ghhhhh";
		
		Boolean hasUppercase = subClass.containsUppercase(testString);
		String whenHasUppercase = hasUppercase ? " an " : " no ";
		String uppercased = subClass.convertToUppercase(testString); // 
		Integer tenPlus = subClass.addTen("003"); //do not pass a string that has a non number example "Star", "*888", "A66"
		
		
		System.out.println("Test string has" + whenHasUppercase + "uppercase");
		System.out.println(uppercased);
		System.out.println(tenPlus);
	}

}
