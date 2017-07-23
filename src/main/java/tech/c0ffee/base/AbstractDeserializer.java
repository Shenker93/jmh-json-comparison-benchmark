package tech.c0ffee.base;

import tech.c0ffee.model.Point;
import tech.c0ffee.model.Rectangle;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * Contains data we need to test and methods that will be overridden by concrete deserializers
 */
@State(Scope.Thread)
public abstract class AbstractDeserializer {
    protected static final String JSON_SMALL = "[{\"x\":1, \"y\":2},{\"x\":3, \"y\":4},{\"x\":5, \"y\":6}]";
    protected static final String JSON_BIG = "[{\"a\":{\"x\":0, \"y\":0},\"b\":{\"x\":0, \"y\":1},\"" +
            "c\":{\"x\":1, \"y\":0},\"d\":{\"x\":1, \"y\":1}}, {\"a\":{\"x\":5, \"y\":5},\"b\":{\"x\":5, \"y\":15}," +
            "\"c\":{\"x\":15, \"y\":5},\"d\":{\"x\":15, \"y\":15}}]";

    /**
     * Deserialize json array as string to {@code Point} array
     */
    public abstract Point[] parseLinear();

    /**
     * Deserialize json array as string to {@code Rectangle} array
     */
    public abstract Rectangle[] parseComplex();
}
