package kyu6;

/**
 * Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
 */
public class Order {

    public static String order(String words) {
        if ("".equals(words))
            return "";

        StringBuilder sb = new StringBuilder();
        String[] array = words.split(" ");
        String[] result = new String[array.length];

        for (String s : array) {
            int i = Integer.parseInt(s.replaceAll("[^0-9]", "")) - 1;
            result[i] = s;
        }

        for (String s : result)
            sb.append(s + " ");

        return sb.toString().trim();
    }

    /**
     * Тест для метода order
     */
    private static void testOrder() {
        String test = "is2 Thi1s T4est 3a";

        System.out.println("Input: " + test);
        System.out.println("Result: " + order(test));
    }

    public static void main(String[] args) {
        testOrder();
    }
}
