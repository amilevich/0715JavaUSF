package Q16;

//Q16. Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).

public class CommandLine {

    public static void main(String[] args) {

        for (String arg: args) {
            System.out.print("The number of characters in the String " + arg + " is: ");
            System.out.println(arg.length());
        }
    }
}
