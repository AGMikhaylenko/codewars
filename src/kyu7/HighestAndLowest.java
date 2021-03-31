package kyu7;

/**
 * In this little assignment you are given a string of space separated numbers,
 * and have to return the highest and lowest number.
 */
public class HighestAndLowest {
    public static void main(String[] args) {
        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
    }

    public static String highAndLow(String numbers) {
        String[] dig = numbers.split(" ");
        int digits[] = new int[dig.length];
        for (int i = 0; i < dig.length; i++)
            digits[i] = Integer.valueOf(dig[i]);

        int maxValue = digits[0];
        int minValue = digits[0];
        for (int i = 1; i < digits.length; i++) {
            if (maxValue < digits[i])
                maxValue = digits[i];
            if (minValue > digits[i])
                minValue = digits[i];
        }
        return maxValue + " " + minValue;
    }
}
