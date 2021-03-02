package kyu4;

import java.util.ArrayList;
import java.util.List;

/**
 * In this kata you have to create all permutations of an input string and remove duplicates, if present.
 * This means, you have to shuffle all letters from the input in all possible orders.
 */
public class Permutations {

    public static void main(String[] args) {
        System.out.println(singlePermutations("a"));
    }

    public static List<String> singlePermutations(String s) {
        ArrayList<String> list = new ArrayList<String>();
        char[] characters = s.toCharArray();
        if(characters.length==1){
            list.add(s);
            return list;
        }
        for (int i = 0; i < characters.length; i++) {
            for (String line : singlePermutations(removeCharAt(s, i))) {
                boolean unique = true;
                for (String inList : list) {
                    if(inList.equals(characters[i]+line))
                        unique = false;
                }
                if(unique)
                    list.add(characters[i]+line);
            }
        }
        return list;
    }

    private static String removeCharAt(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
