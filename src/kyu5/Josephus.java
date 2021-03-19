package kyu5;

import java.util.ArrayList;
import java.util.List;

/**
 * You are now to create a function that returns a Josephus permutation, taking as parameters the initial array/list
 * of items to be permuted as if they were in a circle and counted out every k places until none remained.
 */
public class Josephus {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<Integer>();
        for (int i = 1; i <= 7; i++)
            test.add(i);

        System.out.println(josephusPermutation(test, 3));
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        ArrayList<T> myItems = (ArrayList<T>) items;
        List<T> result = new ArrayList<T>();

        int currentIndex = 0;
        while (myItems.size() != 0) {
            if (currentIndex == 0)
                currentIndex += k;
            else {
                currentIndex += k - 1;
            }
            currentIndex = currentIndex % myItems.size() == 0 ? myItems.size() : currentIndex % myItems.size();

            result.add(myItems.get(currentIndex - 1));
            myItems.remove(currentIndex - 1);
        }
        return result;
    }

}
