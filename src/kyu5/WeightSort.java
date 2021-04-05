package kyu5;

import java.util.ArrayList;
import java.util.Comparator;


/**
 * https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java
 */
public class WeightSort {
    public static void main(String[] args) {
        String testOne = "59544965313";
        String testTwo = "56 65 74 100 99 68 86 180 90";
        System.out.println(orderWeight(testOne));
        System.out.println(orderWeight(testTwo));
    }

    public static String orderWeight(String strng) {
        ArrayList<Weight> list = new ArrayList<>();
        String[] values = strng.trim().split(" ");
        for (String s : values) {
            s = s.trim();
            if (s.length() != 0)
                list.add(new Weight(Long.valueOf(s)));
        }

        list.sort(new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                if (o1.weight == o2.weight)
                    return String.valueOf(o1.value).compareTo(String.valueOf(o2.value));
                else
                    return o1.weight - o2.weight;
            }
        });

        String result = "";
        for (int i = 0; i < list.size(); i++)
            result += list.get(i).value + " ";

        return result.trim();
    }

    private static class Weight {
        private long value;
        private int weight;

        public Weight(long value) {
            this.value = value;
            getWeight();
        }

        private void getWeight() {
            char[] digits = String.valueOf(value).toCharArray();
            for (int i = 0; i < digits.length; i++)
                weight += Integer.valueOf(String.valueOf(digits[i]));
        }
    }
}
