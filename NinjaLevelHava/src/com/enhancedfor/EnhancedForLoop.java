package com.enhancedfor;

public class EnhancedForLoop {
    //Q12. Write a program to store numbers from 1 to 100 in an array.
	//Print out all the even numbers from the array. Use the enhanced FOR loop for
	//printing out the numbers.

	public static void main(String[] args) {
		
		int[] myArr = new int[100];
		
		for(int i = 0; i < myArr.length; i++) {
			myArr[i] = i ;
		}
		for(int x : myArr) { 
			if (myArr[x] == 0) {
				continue;
			}
			if((myArr[x] % 2)== 0) {
				System.out.print(x +" ");
			}
		}

	}

}
