package kyu6;

/**
 * You are going to be given an array of integers. Your job is to take that array and find an index N
 * where the sum of the integers to the left of N is equal to the sum of the integers to the right of N.
 * If there is no index that would make this happen, return -1.
 */
public class Kata {
    public static int findEvenIndex(int[] arr) {
        int left, right;
        for (int i = 0; i < arr.length; i++) {
            left = right = 0;
            for (int l = 0; l < i; l++)
                left += arr[l];
            for (int r = i + 1; r < arr.length; r++)
                right += arr[r];
            if (left == right)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]test = {1,100,50,-51,1,1};
        System.out.println(findEvenIndex(test));
    }
}
