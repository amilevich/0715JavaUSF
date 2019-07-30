package com.homework.question18;

public class ConcreteSubclass extends ControlImpl {

	@Override
	public boolean checkUpperCase(String arr) {
		
		char chr;
		String temp = new String();
		String comp = new String();
		
		for(int i = 0; i < arr.length(); i++) {
			int  originalvalue;
			chr = arr.charAt(i);
			//Take the vakue ASCII
			originalvalue = chr;
			if((originalvalue >= 65 && originalvalue <= 90) || (originalvalue >= 97 && originalvalue <= 122)) {
				temp += chr;
				comp = temp.toUpperCase();
				if(temp.equals(comp)) return true;
			}		
			temp = "";
		}	
		return false;		
	}

	@Override
	public String lowerCase(String arr) {
		//Convert to UpperCase
		return arr.toUpperCase();
		
	}

	@Override
	public int stringToNumber(String arr) {
		char chr;
		String result = new String();
		
		for(int i  = 0; i < arr.length(); i++) {
			
			chr = arr.charAt(i);
			//Take the number of  the array
			if(chr >= '0' && chr <= '9') {
				result += chr;
			}			
		}
		if(result.equals("")) return 10;
		
		return Integer.parseInt(result) + 10;
		
	}	

}
