package kyu6;

import java.util.Scanner;

/**
 * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
 * which is the number of times you must multiply the digits in num until you reach a single digit.
 */
public class Persist {
    public static int persistence(long n) {
        if (n < 10) {
            return 0;
        } else {
            long l = 1;
            while (n != 0) {
                l *= n % 10;
                n /= 10;
            }
            return 1 + persistence(l);
        }
    }

    public static void testPersistence(long n){
        System.out.println("Number is " + n);
        System.out.println("Multiplicative persistence = "+ persistence(n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Input the number: ");
            long l = Long.parseLong(sc.nextLine());
            testPersistence(l);
        }catch (Exception exc){
            System.out.println("Oops! "+ exc.getMessage());
        }finally {
            sc.close();
        }
    }
}
