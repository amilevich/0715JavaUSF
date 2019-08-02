package com.fibbonnacci.assignments;

public class Fibbonnacci { 

	//int c = 26.MY reason for 26 is because the system counts 0 as the first number
	// so to get the first 25, I had to input 26. 
	// In the for() ++m is used to increment(also I got tired of using i which is why it is m)
	public static void main(String[] args) { //Again main method, speaks for itself
	    int c = 26, d5 = 0, d6 = 1;
	    System.out.print("First " + c + " terms: ");
	    for (int m = 1; m <= c; ++m)
	    {
	        System.out.print(d5 + " + "); // the + in the quotation results in a num
	        //+ num being added together(example below 0+1+1+2) which just means
	        // that the numbers are being added together as it goes(It also looks
	        //better than it does when the + sign is not there)
	        int sum = d5 + d6; //int is stating what the two variables are
	        d5 = d6; //statement that one variables is now equal to the other
	        d6 = sum;//stating that the variable is now this variables

}		
    }
}
