package kyu5;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764.
 * The sum of the squared divisors is 2500 which is 50 * 50, a square!
 * Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square.
 * 42 is such a number.
 * The result will be an array of arrays or of tuples (in C an array of Pair) or a string, each subarray having two elements,
 * first the number whose squared divisors is a square and then the sum of the squared divisors.
 */
public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        StringBuilder sb = new StringBuilder();
        for (long i = m; i <= n; i++) {
            List<Long> divisors = new ArrayList<>();
            for (long j = 1; j <= i; j++)
                if (i % j == 0)
                    divisors.add(j);
            long sum = 0;
            for (Long l : divisors)
                sum += l * l;
            if ((Math.sqrt(sum)) % 1.0 == 0) {
                sb.append("["+i+", "+sum+"] ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number: ");
        try {
            System.out.println("M = ");
            int m = Integer.parseInt(sc.nextLine());
            System.out.println("N = ");
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(listSquared(m, n));
        } catch (Exception exc) {
            System.out.println("Oops! " + exc.getMessage());
        } finally {
            if (sc != null)
                sc.close();
        }
    }
}
