package kyu4;

import java.util.Stack;

/**
 * You are at position [0, 0] in maze NxN and you can only move in one of the four cardinal directions
 * (i.e. North, East, South, West). Return true if you can reach position [N-1, N-1] or false otherwise.
 * Empty positions are marked ..
 * Walls are marked W.
 * Start and exit positions are empty in all test cases.
 */
public class Finder {

    static Point[][] points;

    public static void main(String[] args) {
        String a = ".W.\n" +
                ".W.\n" +
                "...";
        String b = ".W.\n" +
                ".W.\n" +
                "W..";
        String c = "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                "......";
        String d = "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                ".....W\n" +
                "....W.";
        System.out.println(pathFinder(a));
        System.out.println(pathFinder(b));
        System.out.println(pathFinder(c));
        System.out.println(pathFinder(d));
    }

    static boolean pathFinder(String maze) {
        parseString(maze);
        Stack<Point> stack = new Stack<>();
        points[0][0].free = false;
        stack.push(points[0][0]);
        do {
            Point p = stack.pop();
            if (p.getX() == points.length - 1 && p.getY() == points.length - 1)
                return true;
            if (p.getY() != 0 && points[p.getY() - 1][p.getX()].free) {
                points[p.getY() - 1][p.getX()].free = false;
                stack.push(points[p.getY() - 1][p.getX()]);
            }
            if (p.getY() != points.length - 1 && points[p.getY() + 1][p.getX()].free) {
                points[p.getY() + 1][p.getX()].free = false;
                stack.push(points[p.getY() + 1][p.getX()]);
            }
            if (p.getX() != 0 && points[p.getY()][p.getX() - 1].free) {
                points[p.getY()][p.getX() - 1].free = false;
                stack.push(points[p.getY()][p.getX() - 1]);
            }
            if (p.getX() != points.length - 1 && points[p.getY()][p.getX() + 1].free) {
                points[p.getY()][p.getX() + 1].free = false;
                stack.push(points[p.getY()][p.getX() + 1]);
            }
        } while (!stack.isEmpty());
        return false;
    }

    private static void parseString(String maze) {
        String[] lines = maze.split("\n");
        int n = lines.length;

        points = new Point[n][n];
        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'W')
                    points[i][j] = new Point(j, i, false);
                else
                    points[i][j] = new Point(j, i, true);
            }
        }
    }

    static class Point {
        int x;
        int y;
        public boolean free;

        public Point(int x, int y, boolean free) {
            this.x = x;
            this.y = y;
            this.free = free;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "|" + free + "]";
        }
    }
}
