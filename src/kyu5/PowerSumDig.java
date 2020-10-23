package kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The number 81 has a special property, a certain power of the sum of its digits is equal to 81 (nine squared).
 * Eighty one (81), is the first number in having this property (not considering numbers of one digit). The next one, is 512.
 * We need to make a function, power_sumDigTerm(), that receives a number n and may output the n-th term of this sequence of numbers.
 */
public class PowerSumDig {

    public static void main(String[] args) {
        System.out.println(powerSumDigTerm(5));
    }

    public static long powerSumDigTerm(int n) {

        ArrayList<Long> digits = new ArrayList<>();

        for (int i = 2; i < 172; i++) {
            long l = i;
            for (int m = 2; m < 10; m++) {
                l *= i;
                if (getSumDigits(l) == i)
                    digits.add(l);
            }
        }

        Collections.sort(digits);
        System.out.println(Arrays.toString(digits.toArray()));
        return digits.get(n - 1);
    }


    public static int getSumDigits(long l) {
        int sum = 0;

        while (l >= 10) {
            sum += l % 10;
            l /= 10;
        }
        sum += l;
        return sum;
    }
}
