package kyu6;

/**
 * https://www.codewars.com/kata/5b40a38f6be5d82775000003/train/java
 */
public class Dinglemouse {
    public static void main(String[] args) {
        crack(new Safe());
    }

    public static int crack(final Safe safe) {
        String combination;
        String first = "L00", second = "L00", third = "L00";
        for (int i = 0; i < 200; i++) {
            if (i < 100)
                first = String.format("L%02d", i);
            else
                first = String.format("R%02d", i - 100);
            combination = first + "-" + second + "-" + third;
            System.out.println(combination);
            if (safe.unlock(combination).equals("click") || safe.unlock(combination).equals("click-click")
                    || safe.unlock(combination).equals("click-click-click"))
                break;
        }

        for (int i = 0; i < 200; i++) {
            if (i < 100)
                second = String.format("L%02d", i);
            else
                second = String.format("R%02d", i - 100);
            combination = first + "-" + second + "-" + third;
            if (safe.unlock(combination).equals("click-click") ||
                    safe.unlock(combination).equals("click-click-click"))
                break;
        }

        for (int i = 0; i < 200; i++) {
            if (i < 100)
                third = String.format("L%02d", i);
            else
                third = String.format("R%02d", i - 100);
            combination = first + "-" + second + "-" + third;
            if (safe.unlock(combination).equals("click-click-click")) {
                System.out.println("Bingo! " + combination);
                break;
            }
        }

        return safe.open();
    }

    static class Safe {
        public String unlock(String s) {
            return "";
        }

        public int open() {
            return 1;
        }
    }
}
