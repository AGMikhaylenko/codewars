package kyu5;

import java.text.Format;

/**
 * Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * The maximum time never exceeds 359999 (99:59:59)
 */
public class HumanReadableTime {

    public static void main(String[] args) {
        System.out.println(makeReadable(0));
        System.out.println(makeReadable(5));
        System.out.println(makeReadable(60));
        System.out.println(makeReadable(86399));
        System.out.println(makeReadable(359999));
    }

    public static String makeReadable(int seconds) {
        if (seconds >= 359999)
            return "99:59:59";

        int[] time = new int[3];

        time[0] = seconds / 3600;
        seconds %= 3600;

        time[1] = seconds / 60;
        time[2] = seconds % 60;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length; i++) {
            if (time[i] >= 10)
                sb.append(time[i]);
            else
                sb.append("0" + time[i]);
            if (i != 2)
                sb.append(":");
        }

        return sb.toString();
    }
}
