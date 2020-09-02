package kyu7;

/**
 * In simple terms, our method does not like the principle of carrying over numbers and just writes down every number it calculates :-)
 * You may assume both integers are positive integers and the result will not be bigger than Integer.MAX_VALUE
 */
public class SillyAddition {

    public static void main(String[] args) {
        System.out.println(add(906, 7088));
    }

    public static int add(int num1, int num2) {
        StringBuilder sb = new StringBuilder();

        char[] c1 = String.valueOf(num1).toCharArray();
        char[] c2 = String.valueOf(num2).toCharArray();

        int[] buf = new int[Math.max(c1.length, c2.length)];
        int delta = c1.length - c2.length;

        if (delta >= 0)
            for (int i = 0; i < c1.length; i++)
                buf[i] = i - delta < 0 ? Integer.valueOf(String.valueOf(c1[i])) : Integer.valueOf(String.valueOf(c1[i]))
                        + Integer.valueOf(String.valueOf(c2[i - delta]));
        else {
            delta = Math.abs(delta);
            for (int i = 0; i < c2.length; i++)
                buf[i] = i - delta < 0 ? Integer.valueOf(String.valueOf(c2[i])) : Integer.valueOf(String.valueOf(c2[i]))
                        + Integer.valueOf(String.valueOf(c1[i - delta]));
        }

        for (int i : buf)
            sb.append(i);

        return Integer.valueOf(sb.toString());
    }
}
