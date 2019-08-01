package q11.a;

import q11.b.B; //imported package with Class B to get float variables

public class A 
{
	public static void main(String[] args) //main method, start of program execution 
	{
		B fun = new B(); //new instance of Class B to become an object
		
		System.out.println(fun.a); //accessing Class B variable "a", and printing the float value
		System.out.println(fun.b); //accessing Class B variable "b", and printing the float value
	}
}
