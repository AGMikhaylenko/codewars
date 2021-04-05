package kyu4;

import java.util.ArrayList;

/**
 * https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/train/java
 * Complete the solution so that it takes a list of integers in increasing order and
 * returns a correctly formatted string in the range format.
 */
public class RangeExtraction {
    public static void main(String[] args) {
        int[] testOne = new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        int[] testTwo = new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20};
        System.out.println(rangeExtraction(testOne));
        System.out.println(rangeExtraction(testTwo));
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> range = new ArrayList<>();
        if (arr.length > 0)
            range.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1)
                range.add(arr[i]);
            else {
                sb.append(printRange(range));
                range = new ArrayList<>();
                range.add(arr[i]);
            }
            if (i == arr.length - 1) {
                sb.append(printRange(range));
            }
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }

    private static String printRange(ArrayList<Integer> range) {
        StringBuilder sb = new StringBuilder();
        if (range.size() >= 3) {
            sb.append(range.get(0)).append('-').append(range.get(range.size() - 1));
            sb.append(',');
        } else {
            for (Integer in : range) {
                sb.append(in).append(',');
            }
        }
        return sb.toString();
    }
}
