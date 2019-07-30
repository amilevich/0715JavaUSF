package com.homework.question11;

import com.homework.question11.first.VariableFloat;

public class FloatPackage {	
	
	public static void main(String[] args) {
		
		VariableFloat vFloat = new VariableFloat();
		
		//Refernce a othe package
		System.out.println(vFloat.numberFloat + " " + vFloat.numberFloat1);
		vFloat.numberFloat ++;
		vFloat.numberFloat1 --;
		System.out.println(vFloat.numberFloat + " " + vFloat.numberFloat1);
		
	}

}
