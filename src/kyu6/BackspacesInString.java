package kyu6;

/**
 * Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"
 * Your task is to process a string with "#" symbols.
 */
public class BackspacesInString {

    public static void main(String[] args) {
        System.out.println(cleanString("abc#d##c"));
    }

    public static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();

        char[] input = s.toCharArray();
        for (char c : input) {
            if ("#".equals(String.valueOf(c))) {
                if (sb.length() != 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
