package kyu4;

import java.util.ArrayList;

/**
 * https://www.codewars.com/kata/5941c545f5c394fef900000c/train/java
 */
public class Warrior {

    public static void main(String[] args) {

    }

    public static final String[] RANKS = {"Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage",
            "Elite", "Conqueror", "Champion", "Master", "Greatest"};

    int level;
    int experience;
    ArrayList<String> achievements;
    String rank;

    public Warrior() {
        achievements = new ArrayList<>();
        update(100);
    }

    private void update(int valueOfExperience) {
        experience += valueOfExperience;
        if (experience > 10000)
            experience = 10000;
        level = experience / 100;
        rank = RANKS[level / 10];
    }

    public String battle(int levelOfEnemy) {
        if (levelOfEnemy < 1 || levelOfEnemy > 100)
            return "Invalid level";

        int different = this.level - levelOfEnemy;
        if (different >= 2)
            return "Easy fight";

        if (this.level / 10 != levelOfEnemy / 10 //Если ранг противника выше
                && different <= -5)
            return "You've been defeated";

        switch (different) {
            case 1:
                update(5);
                return "A good fight";
            case 0:
                update(10);
                return "A good fight";
            default:
                update(20 * different * different);
                return "An intense fight";
        }
    }

    public String training(String description, int exp, int minLevel) {
        if (this.level < minLevel)
            return "Not strong enough";

        achievements.add(description);
        update(exp);
        return description;
    }


    public int level() {
        return this.level;
    }

    public int experience() {
        return this.experience;
    }

    public ArrayList<String> achievements() {
        return this.achievements;
    }

    public String rank() {
        return this.rank;
    }
}
