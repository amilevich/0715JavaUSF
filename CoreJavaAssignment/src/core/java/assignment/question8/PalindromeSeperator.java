package core.java.assignment.question8;

import java.util.ArrayList;

public class PalindromeSeperator
{
    ArrayList<String> randomWords = new ArrayList<String>();

    public PalindromeSeperator()
    {
        randomWords.add("karen");
        randomWords.add("madam");
        randomWords.add("tom");
        randomWords.add("civic");
        randomWords.add("radar");
        randomWords.add("jimmy");
        randomWords.add("kayak");
        randomWords.add("john");
        randomWords.add("refer");
        randomWords.add("billy");
        randomWords.add("did");
    }

    /*
     * Takes in an arraylist and returns a new arraylist containing just the palandromes.
     */
    public ArrayList<String> seperatePalindromes()
    {
        ArrayList<String> palindromes = new ArrayList<String>();

        for(String word : randomWords)
        {
            if(isPalendrome(word))
            {
                palindromes.add(word);
            }
        }

        return palindromes;
    }

    /*
     * Determines if a String is a palindrome. Utilizes the string builder class to reverse the string.
     */
    private static boolean isPalendrome(String word)
    {
        StringBuilder builder = new StringBuilder(word);

        return word.equals(builder.reverse().toString());
    }
}
