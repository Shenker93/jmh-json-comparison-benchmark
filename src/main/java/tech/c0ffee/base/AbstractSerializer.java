package tech.c0ffee.base;

import tech.c0ffee.model.Point;
import tech.c0ffee.model.Rectangle;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains data init methods we need to prepare for test, and methods that will be overridden by concrete serializers
 */
@State(Scope.Thread)
public abstract class AbstractSerializer {

    protected List<Point> points;
    protected List<Rectangle> rectangles;
    protected Rectangle testObject;

    public static final int NUMBER_OF_ITERATIONS = 10;
    public static final int NUMBER_OF_ELEMENTS = 40;

    /**
     * Prepares data for benchmarking test.
     * According to annotation, JMH runs it before benchmarking process
     */
    @Setup
    public void init() {

        points = new ArrayList<>(NUMBER_OF_ELEMENTS);
        for(int i = 0; i < NUMBER_OF_ELEMENTS; i++){
            points.add(Point.RandomPointBuilder.build());
        }

        rectangles = new ArrayList<>(NUMBER_OF_ELEMENTS);
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++){
            rectangles.add(Rectangle.RandomRectangleBuilder.build());
        }

        testObject = Rectangle.RandomRectangleBuilder.build();
    }

    /**
     * Serializes list of points to json string
     */
    public abstract String pointsToJsonArrayString();

    /**
     * Serializes list of rectangles to json string
     */
    public abstract String rectanglesToJsonArrayString();

    /**
     * Serializes single rectangle to json string
     */
    public abstract String objectToJsonString();
}
