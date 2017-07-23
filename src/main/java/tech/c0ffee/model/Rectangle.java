package tech.c0ffee.model;

import tech.c0ffee.model.Point.RandomPointBuilder;

public class Rectangle {

    private Point a;
    private Point b;
    private Point c;
    private Point d;


// Jackson requires empty constructor to build class instance
    public Rectangle(){
    }

    private Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public static class RandomRectangleBuilder {

        public static Rectangle build() {

            return new Rectangle(
                    RandomPointBuilder.build(),
                    RandomPointBuilder.build(),
                    RandomPointBuilder.build(),
                    RandomPointBuilder.build()
            );
        }
    }

    @Override
    public String toString() {
        return a.getX() + ":" + a.getY() + "\n" +
                b.getX() + ":" + b.getY() + "\n" +
                c.getX() + ":" + c.getY() + "\n" +
                d.getX() + ":" + d.getY() + "\n";
    }
}
