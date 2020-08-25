package kyu6;

import java.util.Scanner;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line.
 * Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?
 * Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.
 */
public class Line {
    public static String tickets(int[] peopleInLine) {
        int countOf25 = 0, countOf50 = 0;

        for (int i : peopleInLine)
            switch (i) {
                case 25:
                    countOf25++;
                    break;
                case 50:
                    if (countOf25 != 0) {
                        countOf25--;
                        countOf50++;
                        break;
                    } else
                        return "NO";
                case 100:
                    if (countOf25 >= 1 && countOf50 >= 1) {
                        countOf25--;
                        countOf50--;
                        break;
                    } else {
                        if (countOf25 >= 3) {
                            countOf25 -= 3;
                            break;
                        } else
                            return "NO";
                    }
            }

        return "YES";
    }

    /**
     * Test from method Ticked
     * @param countOfPeople Count of people
     */
    public static void testTickets(int countOfPeople) {
        int [] people = new int[countOfPeople];
        int dollars [] = {25,50,100};

        for(int i = 0; i< countOfPeople;i++){
            people[i] = dollars[(int)(Math.random()*3)];
        }

        System.out.println("Test array:");
        for(int i:people){
            System.out.print(i+" ");
        }

        System.out.println("Result = "  + tickets(people));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Input count of people: ");
            int n = Integer.parseInt(sc.nextLine());
            testTickets(n);
        }catch (Exception exc){
            System.out.println("Oops! " + exc.getMessage());
        }finally {
            sc.close();
        }
    }


}
