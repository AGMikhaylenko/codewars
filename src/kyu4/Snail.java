package kyu4;

import java.util.Arrays;

/**
 * Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
 * array = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * snail(array) #=> [1,2,3,6,9,8,7,4,5]
 */
public class Snail {

    public static int[] snail(int[][] array) {
        //Расчет длины исходящего массива. Проверка входящего массива на нулевую длину
        int step = array.length * array[0].length;
        if (step == 0) {
            return new int[0];
        }
        int[] result = new int[step];

        int row = 0, column = 0;
        int minRow = 0, maxRow = array.length - 1;
        int minCol = 0, maxCol = array.length - 1;
        int iteratorRow = 1, iteratorColumn = 1;
        boolean goColumn = true;

        for (int i = 0; i < step; i++) {
            result[i] = array[row][column];

            //Проверка поворота
            if (goColumn) {
                if (column == maxCol && iteratorColumn == 1) {
                    //Поворот справа вниз
                    goColumn = false;
                    iteratorRow = 1;
                    minRow++;
                }
                if (column == minCol && iteratorColumn == -1) {
                    //Поворот слева вверх
                    goColumn = false;
                    iteratorRow = -1;
                    maxRow--;
                }
            } else {
                if (row == maxRow && iteratorRow == 1) {
                    //Поворот снизу налево
                    goColumn = true;
                    iteratorColumn = -1;
                    maxCol--;
                }
                if (row == minRow && iteratorRow == -1) {
                    //Поворот сверху направо
                    goColumn = true;
                    iteratorColumn = 1;
                    minCol++;
                }
            }

            //Расчет координат следующей ячейки
            if (goColumn) {
                column += iteratorColumn;
            } else {
                row += iteratorRow;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int[][] arrFive = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};


        System.out.println(Arrays.deepToString(arrFive));
        int[] res = snail(arrFive);
        System.out.println(Arrays.toString(res));

    }
}
