package kyu5;

import java.util.Stack;

/**
 * Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
 * The function should return true if the string is valid, and false if it's invalid.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(validParentheses("32423(sgsdg)"));
        System.out.println(validParentheses("(dsgdsg))2432"));
        System.out.println(validParentheses("adasdasfa"));
        System.out.println(validParentheses(""));
    }

    public static boolean validParentheses(String parens) {
        Stack<Character> parentheses = new Stack<Character>();
        char[] letters = parens.toCharArray();
        for (int i = 0; i < letters.length; i++){
            if(letters[i] == '(')
                parentheses.push('(');
            else{
                if(letters[i] == ')'){
                    if(parentheses.empty())
                        return false;
                    else
                        parentheses.pop();
                }
            }
        }
        return parentheses.empty();
    }
}
