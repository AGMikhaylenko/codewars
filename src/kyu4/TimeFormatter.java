package kyu4;

import java.util.*;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration,
 * given as a number of seconds, in a human-friendly way.
 * The function must accept a non-negative integer. If it is zero, it just returns "now".
 * Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 */
public class TimeFormatter {

    private final static int SECOND_IN_MINUTE = 60;
    private final static int SECOND_IN_HOUR = 60 * 60;
    private final static int SECOND_IN_DAY = 24 * 60 * 60;
    private final static int SECOND_IN_YEAR = 365 * 24 * 60 * 60;

    private static TimeUnit[] timeUnits = {new TimeUnit(SECOND_IN_YEAR, "year"),
            new TimeUnit(SECOND_IN_DAY, "day"),
            new TimeUnit(SECOND_IN_HOUR, "hour"),
            new TimeUnit(SECOND_IN_MINUTE, "minute"),
            new TimeUnit(1, "second")};

    public static void main(String[] args) {
        System.out.println(formatDuration(3662));
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0)
            return "now";

        setValueBySecond(seconds);

        StringBuilder builderTime = new StringBuilder();
        for (int i = 0; i < timeUnits.length; i++) {
            if (timeUnits[i].getValue() != 0)
                builderTime.append(timeUnits[i].toString() + ", ");
        }
        builderTime.delete(builderTime.length() - 2, builderTime.length());
        int index;
        if ((index = builderTime.lastIndexOf(",")) != -1) {
            builderTime.replace(index, index + 1, " and");
        }
        return builderTime.toString();
    }

    public static void setValueBySecond(int seconds) {
        for (int i = 0; i < timeUnits.length; i++) {
            timeUnits[i].setValue(seconds / timeUnits[i].getSecondInUnit());
            seconds %= timeUnits[i].getSecondInUnit();
        }
    }

    static class TimeUnit {
        private int secondInUnit;
        private int value;
        private String name;

        public TimeUnit(int secondInUnit, String name) {
            this.secondInUnit = secondInUnit;
            this.name = name;
        }

        public void setValue(int value) {
            if (value >= 0)
                this.value = value;
            else
                throw new IllegalArgumentException();
        }

        public int getSecondInUnit() {
            return secondInUnit;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            if (this.value > 1)
                return this.value + " " + this.name + "s";
            else
                return this.value + " " + this.name;
        }
    }
}
