package kyu6;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * https://www.codewars.com/kata/55b3425df71c1201a800009c/train/java
 */
public class Statistics {

    public static void main(String[] args) {
        String testOne = "01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17";
        String testTwo = "02|15|59, 2|47|16, 02|17|20, 2|32|34, 2|17|17, 2|22|00, 2|31|41";
        System.out.println(stat(testOne));
        System.out.println(stat(testTwo));
    }

    public static String stat(String strg) {
        if (strg.length() == 0)
            return "";

        String[] lines = strg.split(",");
        ArrayList<Integer> resultsInSeconds = new ArrayList<>();
        for (String s : lines) {
            String[] digits = s.trim().split("\\|");
            int result = 0;
            for (int i = 0; i < digits.length; i++)
                result += Integer.parseInt(digits[i]) * (int) Math.pow(60, digits.length - i - 1);
            resultsInSeconds.add(result);
        }

        resultsInSeconds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int range = resultsInSeconds.get(resultsInSeconds.size() - 1) - resultsInSeconds.get(0);

        int average = 0;
        for (Integer i : resultsInSeconds)
            average += i;
        average /= resultsInSeconds.size();

        int median = resultsInSeconds.size() % 2 == 0 ?
                (resultsInSeconds.get(resultsInSeconds.size() / 2) + resultsInSeconds.get(resultsInSeconds.size() / 2 - 1)) / 2 :
                resultsInSeconds.get(resultsInSeconds.size() / 2);

        return "Range: " + getStringFromSeconds(range) + " Average: " + getStringFromSeconds(average) +
                " Median: " + getStringFromSeconds(median);
    }

    private static String getStringFromSeconds(int seconds) {
        String result = "";
        for (int i = 2; i >= 0; i--) {
            result += String.format("%02d", seconds / (int) Math.pow(60, i));
            result += "|";
            seconds %= (int) Math.pow(60, i);
        }
        return result.substring(0, result.length() - 1);
    }
}
