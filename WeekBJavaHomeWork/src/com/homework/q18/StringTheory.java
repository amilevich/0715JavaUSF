package com.homework.q18;
import java.lang.String;
public class StringTheory extends AbstractStringTheory {

	@Override
	boolean isUppercase(String words) {
		for (int i = 0; i < words.length()-1; i++) {
			if(Character.isUpperCase(words.charAt(i)));
		}
		return false;
	}

	@Override
	String makeUpperCase(String words) {
		
		return words.toUpperCase();
	}

	@Override
	int itsAboutTheNumbers(String words) {
		return (Integer.parseInt(words,32)) + 10; //need to work arround the thrown exception NumberFormatException
	}
	
	
	
	public static void main(String[] args) {
		StringTheory theory = new StringTheory();
		
		System.out.println(theory.makeUpperCase("loud noises"));
		System.out.println(theory.itsAboutTheNumbers("BigNumber"));
	}

}
