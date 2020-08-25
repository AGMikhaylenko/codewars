package kyu6;

import java.util.Scanner;

/**
 * Write a function that takes in a string of one or more words, and returns the same string,
 * but with all five or more letter words reversed (Just like the name of this Kata).
 * Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.
 * <p>
 * Examples: spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" spinWords( "This is a test") =>
 * returns "This is a test" spinWords( "This is another test" )=> returns "This is rehtona test"
 */
public class SpinWords {

    public static String spinWords(String sentence) {
        StringBuilder sc = new StringBuilder();

        String[] words = sentence.split(" ");
        for (String s : words) {
            sc.append(s.toCharArray().length < 5 ? s : new StringBuilder(s).reverse().toString());
            sc.append(" ");
        }
        return sc.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input word:");
            String s = sc.nextLine();
            System.out.println(spinWords(s));
        } catch (Exception exc) {
            System.out.println("Oops! " + exc.getMessage());
        } finally {
            sc.close();
        }
    }
}
