package kyu8;

/**
 * Write function bmi that calculates body mass index (bmi = weight / height2).
 * if bmi <= 18.5 return "Underweight"
 * if bmi <= 25.0 return "Normal"
 * if bmi <= 30.0 return "Overweight"
 * if bmi > 30 return "Obese"
 */
public class CalculateBMI {

    public static void main(String[] args) {
        System.out.println(bmi(66, 1.78));
    }

    public static String bmi(double weight, double height) {
        double indexBMI = weight / Math.pow(height, 2);

        if (indexBMI <= 18.5)
            return "Underweight";
        if (indexBMI <= 25.0)
            return "Normal";
        if (indexBMI <= 30)
            return "Overweight";

        return "Obese";
    }
}
