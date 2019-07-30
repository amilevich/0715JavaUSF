package com.homework.question20;

import java.io.File;
import java.util.Scanner;

public class ReadFile {
	
	Scanner readF;
	
	public void openFile() {
		try {
			readF= new Scanner(new File("C:\\Revature\\Homework\\Data.txt"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void readFile() {
		while(readF.hasNext()) {
			String a = readF.next();
			System.out.println(a);						
			System.out.print("Name: ");
			for(int i = 0 ; i < 2; i++){
				int j = a.indexOf(":");
				System.out.print(a.substring(0, j) + " ");
				a = a.substring(j + 1, a.length());
			}
			System.out.println("");
			int i = a.indexOf(":");
			System.out.println("Age: " + a.subSequence(0, i) + " years");
			a = a.substring(i + 1, a.length());
			System.out.println("State: " + a + " State");
			System.out.println("");
			System.out.println("");
			
		}
		
		readF.close();
	}
	
	

}
