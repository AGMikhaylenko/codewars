package kyu6;

import java.util.Arrays;

public class SumParts {

    public static void main(String[] args) {
        int[] ls = {0, 1, 3, 6, 10};
        System.out.println(Arrays.toString(sumParts(ls)));
    }

    public static int[] sumParts(int[] ls) {
        int[] sums = new int[ls.length + 1];
        sums[sums.length - 1] = 0;

        for (int i = ls.length - 1; i >= 0; i--)
            sums[i] = sums[i + 1] + ls[i];

        return sums;
    }
}
