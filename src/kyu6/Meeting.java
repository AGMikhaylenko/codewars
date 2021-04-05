package kyu6;

import java.util.ArrayList;
import java.util.Comparator;

public class Meeting {

    public static void main(String[] args) {
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;" +
                "Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(meeting(s));
    }

    public static String meeting(String s) {
        String[] lines = s.split(";");
        ArrayList<Human> humans = new ArrayList<>();
        for (String line : lines) {
            humans.add(new Human(line));
        }

        humans.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                int i;
                if ((i = o1.secondName.compareTo(o2.secondName)) != 0)
                    return i;
                else
                    return o1.firstName.compareTo(o2.firstName);
            }
        });

        String result = "";
        for (int i = 0; i < humans.size(); i++) {
            result += humans.get(i).toString();
        }

        return result;
    }

    static class Human {
        private String firstName;
        private String secondName;

        public Human(String name) {
            String[] line = name.split(":");
            this.firstName = line[0].toUpperCase();
            this.secondName = line[1].toUpperCase();
        }

        @Override
        public String toString() {
            return "(" + secondName + ", " + firstName + ")";
        }
    }
}
