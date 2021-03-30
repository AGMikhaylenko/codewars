package kyu6;

/**
 * You throw a ball vertically upwards with an initial speed v (in km per hour). The height h of the ball at each time
 * t is given by h = v*t - 0.5*g*t*t where g is Earth's gravity (g ~ 9.81 m/s**2). A device is recording at every
 * tenth of second the height of the ball. For example with v = 15 km/h the device gets something of the following
 * form: (0, 0.0), (1, 0.367...), (2, 0.637...), (3, 0.808...), (4, 0.881..) ... where the first number is the time
 * in tenth of second and the second number the height in meter.
 * Write a function max_ball with parameter v (in km per hour) that returns the time in tenth of second of
 * the maximum height recorded by the device.
 */
public class MaxHeight {

    private static final double G = 9.81;

    public static void main(String[] args) {
        System.out.println(maxBall(45));
    }

    public static int maxBall(int v0) {
        double v = v0 / 3.6;
        double tMax = v / G;
        double t1 = tMax - tMax % 0.1;
        double t2 = t1 + 0.1;
        return getHeight(v, t1) > getHeight(v, t2) ? (int) (t1 * 10) : (int) (t2 * 10);
    }

    public static double getHeight(double v, double t) {
        return v * t - 0.5 * G * t * t;
    }
}
