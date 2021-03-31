package kyu7;

/**
 * Count the number of divisors of a positive integer n.
 */
public class CountOfDivisors {
    public static void main(String[] args) {
        System.out.println(numberOfDivisors(12));
    }

    public static long numberOfDivisors(int n) {
        long count = 0;
        for (int i = 1; i <=n; i++) {
            if (n % i == 0)
                count++;
        }
        return count;
    }
}
