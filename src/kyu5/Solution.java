package kyu5;

/**
 * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
 */
public class Solution {
    public static void main(String[] args) {
        int i = 150;
        System.out.println(zeros(i));
    }

    public static int zeros(int n) {
        int zeros = 0, pow = 1;
        while (n / Math.pow(5, pow) > 0) {
            zeros += n / Math.pow(5, pow);
            pow++;
        }
        return zeros;
    }
}
