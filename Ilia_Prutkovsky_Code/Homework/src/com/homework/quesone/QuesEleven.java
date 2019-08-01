package com.homework.quesone;

import com.homework.queseleven.QuesElev;

// Write a program that would access two float-variables from a class that exists in another package. 
// Note, you will need to create two packages to demonstrate the solution.

public class QuesEleven {
	
	public static void main(String[] args) {
		QuesElev obj = new QuesElev();
		System.out.println(obj.getF1());
		System.out.println(obj.getF2());
	}
}
