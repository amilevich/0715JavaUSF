package com.qsixteen;

public class MainCommand {
	// pass a string into args
	public static void main(String[] args) {
		// ok so looked this up, and you right click on your .java in the package
		// explorer, go to "Run As", "Run Configurations", "Arguments" tab, and enter
		// the string into "Program arguments".
		
		//in this case the string is "hello boss"

		//this prints out the length of any string in args
		for (String i : args) {
			System.out.println(i.length());
		}

	}

}
