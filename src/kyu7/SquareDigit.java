package kyu7;

import java.util.Scanner;

/**
 * Welcome. In this kata, you are asked to square every digit of a number and concatenate them.
 * For example, if we run 9119 through the function, 811181 will come out, because 9^2 is 81 and 1^2 is 1.
 * Note: The function accepts an integer and returns an integer
 */
public class SquareDigit {

    /**
     *
     * @param n Number
     * @return
     */
    public static int squareDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        char [] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char c:arr){
            sb.append(Integer.parseInt(String.valueOf(c))*Integer.parseInt(String.valueOf(c)));
        }

        return Integer.parseInt(sb.toString());
    }

    /**
     * Test for method squareDigits
     * @param n Number
     */
    public static void testSquare(int n){
        System.out.println("N = " + n);
        System.out.println("Result of method = " + squareDigits(n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number: ");
        try {
            int n = Integer.parseInt(sc.nextLine());
            testSquare(n);
        }catch (Exception exc){
            System.out.println("Oops! " + exc.getMessage());
        }finally {
            sc.close();
        }

    }
}
