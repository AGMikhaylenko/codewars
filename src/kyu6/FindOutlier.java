package kyu6;

import java.util.Scanner;

/**
 * You are given an array (which will have a length of at least 3, but could be very large) containing integers.
 * The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
 * Write a method that takes the array as an argument and returns this "outlier" N.
 */
public class FindOutlier {
    static int find(int[] integers) {
        int countOdd = 0, countEven = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0)
                countEven++;
            else
                countOdd++;
        }

        boolean arrayIsOdd = countOdd > countEven ? true : false;

        for (int i : integers) {
            if (arrayIsOdd && i % 2 == 0)
                return i;
            if (!arrayIsOdd && i % 2 != 0)
                return i;
        }
        return 0;
    }

    /**
     * Тест для метода find
     */
    private static void testFind() {
        int[] test = {1, 3, 0, 13, 8};

        System.out.println("Array:");
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }

        System.out.println("N = " + find(test));
    }

    public static void main(String[] args) {
        testFind();
    }
}
