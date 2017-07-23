package tech.c0ffee.model;

import java.util.Random;

public class Point {

    private int x;
    private int y;

    // Jackson requires empty constructor to build class instance
    public Point(){
    }

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static class RandomPointBuilder {
        private static final Random random = new Random();

        public static Point build() {
            return new Point(
                    random.nextInt(100),
                    random.nextInt(100)
            );
        }
    }
}
