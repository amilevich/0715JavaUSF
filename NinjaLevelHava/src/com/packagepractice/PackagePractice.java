package com.packagepractice;
import com.ternary.Ternary;
import com.ternary.Ternary.*;

//Q11. Write a program that would access two float-variables from a class
//that exists in another package. Note, you will need to create two packages to
//demonstrate the solution.

public class PackagePractice {

	//I used the package from Q10 Ternary operator for Q11
	public static void main(String[] args) {
		System.out.println(Ternary.x + " "+Ternary.y);

	}

}
