package q18.abstracter.it;

public class Runner //main method class for running methods from the Child class
{
	public static void main(String[] args)  //main method, execution of program starts here
	{
		String Banner = "orever"; //initialization of String variable Banner
		String Number = "10"; //initialization of String variable Number
		
		Child baba = new Child();		//new instance of Child class as an object with reference variable "baba"
		
		System.out.println(baba.isStringUpperCase(Banner)); //printing return value of isStringUpperCase method to see if the String passed in has an upper case character
		
		System.out.println(baba.upperCaseConv(Banner)); //printing out the return value from upperCaseConv method from Child class, converts String to all uppercase
		
		baba.convertString(Number); //method prints out the value of a String converted to an integer and with 10 added to it
		
		
	}
}
