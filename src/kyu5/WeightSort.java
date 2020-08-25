package kyu5;

public class WeightSort {

    public static String orderWeight(String strng) {
        String[] words = strng.trim().split(" ");
        int[] weight = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            weight[i] = 0;
            char[] chars = words[i].trim().toCharArray();
            for (char c : chars) {
                weight[i] += Integer.parseInt(String.valueOf(c));
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = weight.length - 1; j > i; j--)
                if (weight[j] < weight[j-1]){
                    int buf = weight[j-1];
                    weight[j-1] = weight[j];
                    weight[j] = buf;
                    String b = words[j-1];
                    words[j-1] = words[j];
                    words[j] = b;
                }
        }

        StringBuilder sb = new StringBuilder();
        for(String s:words){
            sb.append(s + " ");
        }
        return sb.toString().trim();
    }

    /**
     * Тест для метода orderWeight
     */
    private static void testOrder() {
        String test = "56 65 74 100 99 68 86 180 90";

        System.out.println("Input: " + test);
        System.out.println("Result: " + orderWeight(test));
    }

    public static void main(String[] args) {
        testOrder();
    }
}
