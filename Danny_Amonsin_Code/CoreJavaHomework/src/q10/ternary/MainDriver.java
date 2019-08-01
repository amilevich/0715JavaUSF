package q10.ternary;

public class MainDriver 
{
	public static void main(String[] args) //main method, start of program execution 
	{
		int x = 10, y = 5; //initialized x and y as integers with values 10 and 5 respectively
		String o = "y is greater than x"; //initialized String "o" as "y is greater than x" 
		String n = "x is greater than y"; //initialized String "n" as "x is greater than y"
		
	    String result = x > y ? n : o; //ternary operator checking if x is greater than y, if it is then n will print, if not, then y will print in the console
	    
	    System.out.println(result); //prints the result of the ternary operator check
	}

}
