package tech.c0ffee.base;

import tech.c0ffee.model.Point;
import tech.c0ffee.model.Rectangle;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains data init methods we need to prepare for test, and methods that will be overridden by concrete serializers
 */
@State(Scope.Thread)
public abstract class AbstractSerializer {

    protected List<Point> points;
    protected List<Rectangle> rectangles;
    protected Rectangle testObject;

    public static final int NUMBER_OF_ITERATIONS = 10;

    /**
     * Prepares data for benchmarking test.
     * According to annotation, JMH runs it before benchmarking process
     */
    @Setup
    public void init() {

        points = Stream.generate(Point.RandomPointBuilder::build)
                .limit(40)
                .collect(Collectors.toList());

        rectangles = Stream.generate(Rectangle.RandomRectangleBuilder::build)
                .limit(40)
                .collect(Collectors.toList());

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
