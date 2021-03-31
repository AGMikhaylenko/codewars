package kyu7;

/**
 * Given a number, write a function to output its reverse digits. (e.g. given 123 the answer is 321)
 * Numbers should preserve their sign; i.e. a negative number should still be negative when reversed.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(321));
        System.out.println(reverse(-321));
        System.out.println(reverse(5));
        System.out.println(reverse(1000));
    }

    public static int reverse(int number) {
        boolean isNegative = number < 0 ? true : false;
        String str = new StringBuilder(String.valueOf(number)).reverse().toString();
        if (isNegative)
            str = str.replace('-', ' ');
        str = str.trim();
        return isNegative ? -1 * Integer.valueOf(str) : Integer.valueOf(str);
    }
}
