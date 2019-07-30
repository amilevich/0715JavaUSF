package com.homework.q11_1;

//To access public fields in a class in another package you must import that class from the package
import com.homework.q11_2.OtherPackage;

public class QuestionEleven
{
	/*
	 * Access two floating point variables from a class in another package
	 */
	
	public static void main(String[] args)
	{
		//After the class is imported, public fields can be accessed through ClassName.variableName
		float one = OtherPackage.x;
		float two = OtherPackage.y;
		
		//Print out the two floats taken from a class in another package
		System.out.println("Floats from a class in another package: " + one + ", " + two);
	}
}