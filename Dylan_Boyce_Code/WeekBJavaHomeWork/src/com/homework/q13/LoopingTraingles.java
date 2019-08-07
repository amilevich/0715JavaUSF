package com.homework.q13;

public class LoopingTraingles {
	
	public static void main(String[] args) { 
		int flag = 0;
		
		//double nested for loop
		for(int i=0; i<4; i++) {  //this loop moves our print line down on every iteration
			for(int j =0; j<i+1; j++) { //this loop implements the logic(in this case, if statements) to print a 1 or 0
			if (flag ==0) {             //based on the flag values, and determines how many of them to print based on
				System.out.print(flag+" "); //the value of (i+1)
				flag = 1;
				continue;
			}
			if(flag ==1) {
				System.out.print(flag+" ");
				flag = 0;
				continue;
			}
			}
			System.out.println(""); //this print statement moves our line down to print the next segment of the triangle
		}
	}
}
