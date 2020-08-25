package kyu6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * You will be given two dimensions
 * 1. a positive integer length (parameter named lng)
 * 2. a positive integer width (parameter named wdth)
 * You will return an array or a string (depending on the language; Shell bash, PowerShell and Fortran return a string) with the size of each of the squares.
 */
public class SqInRect {

    public static List<Integer> sqInRectWithRec(int lng, int wdth) {
        List<Integer> list = new ArrayList<>();
        if (lng == wdth) {
            list.add(lng);
            return list;
        }
        if (lng > wdth) {
            list.add(wdth);
            lng -= wdth;
        }else{
            list.add(lng);
            wdth -=lng;
        }
        list.addAll(sqInRectWithRec(lng, wdth));
        return list;
    }

    public static List<Integer> sqInRectWhithoutRec(int lng, int wdth) {
        List<Integer> list = new ArrayList<>();
        if (lng == wdth) {
            return null;
        }

        while(true) {
            if(lng == wdth){
                list.add(lng);
                return list;
            }
            if (lng > wdth) {
                list.add(wdth);
                lng -= wdth;
            } else {
                list.add(lng);
                wdth -= lng;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Input length: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.println("Input width: ");
            int b = Integer.parseInt(sc.nextLine());
            List<Integer> result = sqInRectWhithoutRec(a, b);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
        } catch (Exception exc) {
            System.out.println("Oops! " + exc.getMessage());
        } finally {
            sc.close();
        }
    }
}
