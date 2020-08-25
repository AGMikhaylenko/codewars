package kyu7;

import java.util.Scanner;

public class Accumul {

    public static String accum(String s) {
        StringBuilder sc = new StringBuilder();
        char[] array = s.toCharArray();
        String upper = "", lower = "";

        for (int i = 0; i < array.length; i++) {
            upper = String.valueOf(array[i]).toUpperCase();
            lower = String.valueOf(array[i]).toLowerCase();
            sc.append(upper);
            for (int j = 0; j < i; j++)
                sc.append(lower);
            //Если элемент не последний - добавляем тире
            if (array.length - i != 1)
                sc.append("-");
        }

        return sc.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input word:");
            String s = sc.nextLine();
            System.out.println(accum(s));
        } catch (Exception exc) {
            System.out.println("Oops! " + exc.getMessage());
        } finally {
            sc.close();
        }
    }
}
