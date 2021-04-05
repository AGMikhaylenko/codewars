package kyu4;


/**
 * Create a function that takes a positive integer and returns the next bigger number
 * that can be formed by rearranging its digits
 */
public class NextBigger {

    public static final long TEST_VALUE = 59884848459853L;

    public static void main(String[] args) {
        System.out.println(nextBiggerNumber(TEST_VALUE));
    }

    public static long nextBiggerNumber(long n) {
        int[] digits = getDigits(n);
        int indexOfLastPositive = getLastIndexOfPositiveDigit(digits);
        int indexOfGoalPermutation = -1;

        //Проверка на ноль
        if (indexOfLastPositive == -1)
            return -1;

        for (int i = indexOfLastPositive; i > 0 && indexOfGoalPermutation == -1; i--) {
            //Проверка на перестановку на меньшую цифру (выход из цикла)
            if (digits[i] > digits[i - 1]) {
                indexOfGoalPermutation = i;
                int indexOfMinValue = i;
                for (int j = i; j < digits.length; j++) {
                    if (digits[j] > digits[i - 1] && digits[j] < digits[indexOfMinValue])
                        indexOfMinValue = j;
                }
                //Перестановка соседних цифр
                int buffer = digits[indexOfMinValue];
                digits[indexOfMinValue] = digits[i - 1];
                digits[i - 1] = buffer;
            }
        }

        //Проверка на возможность перестановки в числе
        if (indexOfGoalPermutation == -1)
            return -1;

        //Сортировка части массива справа от целевой перестановки. Пузырек
        for (int i = indexOfGoalPermutation; i < digits.length; i++) {
            for (int j = digits.length - 1; j > i; j--)
                if (digits[j] < digits[j - 1]) {
                    int buffer = digits[j];
                    digits[j] = digits[j - 1];
                    digits[j - 1] = buffer;
                }
        }

        return getLong(digits);
    }

    /**
     * Разбитие числа на массив цифр
     *
     * @param n Число
     * @return Массив цифр
     */
    private static int[] getDigits(long n) {
        char[] digitsChar = String.valueOf(n).toCharArray();
        int[] digits = new int[digitsChar.length];
        for (int i = 0; i < digits.length; i++)
            digits[i] = Integer.valueOf(String.valueOf(digitsChar[i]));
        return digits;
    }

    /**
     * Составление числа из массива цифр
     *
     * @param digits массив цифр
     * @return Итоговое число
     */
    private static long getLong(int[] digits) {
        long result = 0;
        for (int i = 0; i < digits.length; i++)
            result += Math.abs(digits[digits.length - i - 1]) * Math.pow(10, i);
        //Если первая цифра отрицательная, то поменять знак на минус
        if (digits.length != 0 && digits[0] < 0)
            result *= -1;

        return result;
    }

    /**
     * Определение индекса последнего положительного числа в массиве
     *
     * @param digits Массив чисел
     * @return Индекс последней положительного числа. Если все числа не положительны, то возвращается -1
     */
    private static int getLastIndexOfPositiveDigit(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) {
            if (digits[index] > 0)
                return index;
        }
        return -1;
    }
}
