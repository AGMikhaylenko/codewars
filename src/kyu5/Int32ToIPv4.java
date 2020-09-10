package kyu5;

import java.util.Arrays;

public class Int32ToIPv4 {

    public static void main(String[] args) {
        System.out.println(longToIP(2149583361L));
    }

    public static String longToIP(long ip) {

        long[] bytes = new long[4];

        for (int i = 1; i <= 4; i++)
            bytes[i - 1] = (ip % (long) Math.pow(2, 8 * i)) / (long) Math.pow(2, 8 * (i - 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--)
            sb.append(bytes[i] + ".");

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
