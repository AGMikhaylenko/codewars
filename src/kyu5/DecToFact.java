package kyu5;

/**
 * Coding decimal numbers with factorials is a way of writing out numbers in a base system that depends on factorials,
 * rather than powers of numbers.
 * <p>
 * In this system, the last digit is always 0 and is in base 0!. The digit before that is either 0 or 1 and is in
 * base 1!. The digit before that is either 0, 1, or 2 and is in base 2!, etc. More generally, the nth-to-last digit
 * is always 0, 1, 2, ..., n and is in base n!.
 */
public class DecToFact {

    private static final char[] CHARACTERS_FOR_FACTORIAL = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90};

    public static void main(String[] args) {
        System.out.println(dec2FactString(1001));
        System.out.println(factString2Dec("1212210"));
    }

    public static String dec2FactString(long nb) {
        StringBuilder sb = new StringBuilder();
        long fact = 0L;
        boolean flag = false;
        for (int i = CHARACTERS_FOR_FACTORIAL.length - 1; i >= 0; i--) {
            fact = getFactorial(i);
            if (nb / fact > 0) {
                flag = true;
                sb.append(CHARACTERS_FOR_FACTORIAL[(int) (nb / fact)]);
                nb %= fact;
            } else {
                if (flag)
                    sb.append(CHARACTERS_FOR_FACTORIAL[0]);
            }
        }
        return sb.toString();
    }

    public static long factString2Dec(String str) {
        long result = 0L;
        char[] digits = str.toCharArray();
        for (int i = 0; i < digits.length; i++) {
            result += findIndexByValue(digits[digits.length - 1 - i]) * getFactorial(i);
        }
        return result;
    }

    public static long getFactorial(int n) {
        long fact = 1L;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }

    public static int findIndexByValue(char c) {
        for (int i = 0; i < CHARACTERS_FOR_FACTORIAL.length; i++) {
            if (c == CHARACTERS_FOR_FACTORIAL[i])
                return i;
        }
        return -1;
    }
}
