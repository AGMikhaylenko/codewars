package kyu5;

/**
 * Implement a function that receives two IPv4 addresses, and returns the number of addresses between them
 * (including the first one, excluding the last one).
 * All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.
 */
public class CountIpAddress {

    public static void main(String[] args) {
        System.out.println(ipsBetween("150.0.0.0", "150.0.0.1"));
    }

    public static long ipsBetween(String start, String end) {
        System.out.println(start + end);
        String[] startAr = start.split("\\.");
        String[] endAr = end.split("\\.");


        int[] startByte = new int[startAr.length];
        int[] endByte = new int[endAr.length];

        long result = 0;

        for (int i = 0; i < 4; i++) {
            startByte[i] = Integer.parseInt(startAr[i]);
            endByte[i] = Integer.parseInt(endAr[i]);

            result += (endByte[i] - startByte[i]) * ((int) Math.pow(256, 3 - i));
        }

        return result;
    }
}
