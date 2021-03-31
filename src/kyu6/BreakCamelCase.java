package kyu6;

/**
 * Complete the solution so that the function will break up camel casing, using a space between words.
 */
public class BreakCamelCase {
    public static void main(String[] args) {
        System.out.println(camelCase("camelCase"));
    }

    public static String camelCase(String input) {
        char[] characters = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            if ((int) characters[i] >= 65 && (int) characters[i] <= 90) {
                sb.append(" ").append((char) (characters[i] + 32));
            } else
                sb.append(characters[i]);
        }
        return sb.toString();
    }
}
