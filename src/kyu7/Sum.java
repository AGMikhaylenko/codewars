package kyu7;

import java.util.Scanner;

/**
 * Given two integers a and b, which can be positive or negative, find the sum of all the numbers between including them too and return it.
 * If the two numbers are equal return a or b.
 * Note: a and b are not ordered!
 */
public class Sum {

    public static int getSum(int a, int b) {
        if (a == b) {
            return a;
        }
        boolean aIsBig = false;
        int res = 0;

        for (int i = a; i != b; ) {
            res += i;
            if (a > b)
                i--;
            else
                i++;
        }
        return res + b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input first number: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.println("Input second number: ");
            int b = Integer.parseInt(sc.nextLine());
            System.out.println("Sum = " + getSum(a, b));
        } catch (Exception exc) {
            System.out.println("Oops! " + exc.getMessage());
        } finally {
            sc.close();
        }
    }
}
