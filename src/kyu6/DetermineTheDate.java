package kyu6;

/**
 * What date corresponds to the nth day of the year?
 * The answer depends on whether the year is a leap year or not.
 */

public class DetermineTheDate {

    final Month[] listOfMonths = {new Month("January", 31),
            new Month("February", 28),
            new Month("March", 31),
            new Month("April", 30),
            new Month("May", 31),
            new Month("June", 30),
            new Month("July", 31),
            new Month("August", 31),
            new Month("September", 30),
            new Month("October", 31),
            new Month("November", 30),
            new Month("December", 31)};

    public static void main(String[] args) {
        System.out.println(getDay(15, false));
        System.out.println(getDay(41, false));
        System.out.println(getDay(59, false));
        System.out.println(getDay(60, false));
        System.out.println(getDay(60, true));
        System.out.println(getDay(365, false));
        System.out.println(getDay(366, true));
    }

    public static String getDay(int day, boolean isLeap) {
        DetermineTheDate d = new DetermineTheDate();

        if (isLeap)
            d.listOfMonths[1].setCountOfDay(29);

        for (int i = 0; i < d.listOfMonths.length; i++) {
            if (day > d.listOfMonths[i].getCountOfDay()) {
                day -= d.listOfMonths[i].getCountOfDay();
            } else {
                return d.listOfMonths[i].getName() + ", " + day;
            }
        }
        return "Y'm sorry!";
    }

    class Month {
        private String name;
        private int countOfDay;

        public Month(String name, int countOfDay) {
            this.name = name;
            this.countOfDay = countOfDay;
        }

        public String getName() {
            return name;
        }

        public int getCountOfDay() {
            return countOfDay;
        }

        public void setCountOfDay(int countOfDay) {
            if (this.name.equals("February"))
                this.countOfDay = countOfDay;
        }
    }
}
