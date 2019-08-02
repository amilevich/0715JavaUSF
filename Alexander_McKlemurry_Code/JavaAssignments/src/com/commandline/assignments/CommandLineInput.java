package com.commandline.assignments;

public class CommandLineInput {

	public static void main(String[] args) 
    { 
        // check if length of args array is 
        // greater than 0 
        if (args.length > 0) 
        { 
            System.out.println("The command line"+ 		//under the influence of cmd, this syso will print 
                               " arguments are:" +args[0].length());//to the console 
  
            // iterating the args array and printing 
            // the command line arguments 
            for (String cal:args) 
                System.out.println(cal.length()); 
        } 
        else			//if there is no command line, the syso below will print to the console
            System.out.println("No command line "+ 
                               "arguments found." +args[0].length()); 
    } 

}
