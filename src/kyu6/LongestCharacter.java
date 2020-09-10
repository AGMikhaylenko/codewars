package kyu6;

import java.util.Arrays;


/**
 * For a given string s find the character c (or C) with longest consecutive repetition and return:
 * Object[]{c, l};
 * where l (or L) is the length of the repetition. If there are two or more characters with the same l return the first in order of appearance.
 */
public class LongestCharacter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestRepetition("aabbccccdasd")));
    }

    public static Object[] longestRepetition(String s) {
        char[] charList = s.toCharArray();

        if (charList.length == 0)
            return new Object[]{"", 0};

        int resCount = 1;
        char resChar = charList[0];

        int x = 1;
        for (int i = 1; i < charList.length; i++) {
            if (charList[i] == charList[i - 1]) {
                x++;
                if (resCount < x) {
                    resCount = x;
                    resChar = charList[i];
                }
            } else {
                x = 1;
            }
        }

        Object[] res = new Object[]{String.valueOf(resChar), resCount};
        return res;
    }
}
