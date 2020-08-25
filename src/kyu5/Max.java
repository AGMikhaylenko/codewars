package kyu5;

import java.util.Scanner;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
 * If the list is made up of only negative numbers, return 0 instead.
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class Max {
    /**
     * Поиск наибольшей суммы последовательных элементов массива
     *
     * @param arr массив чисел
     * @return Наибольшая сумма
     */
    public static int sequence(int[] arr) {
        if (arr.length == 0)
            return 0;

        int max = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (max < sum)
                    max = sum;
            }
        }
        return max;
    }

    /**
     * Тест для метода sequence
     *
     * @param n Количество элементов в массиве
     */
    private static void testSequence(int n) {
        int[] test = new int[n];

        System.out.println("Array:");
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 20) - 10;
            System.out.print(test[i] + " ");
        }

        System.out.println("\nSum = " + sequence(test));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input count of numbers: ");
            int n = Integer.parseInt(sc.nextLine());
            testSequence(n);
        } catch (Exception exc) {
            System.out.println("Oops! " + exc.getMessage());
        } finally {
            sc.close();
        }
    }

}
