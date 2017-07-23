package tech.c0ffee.gson;

import com.google.gson.Gson;
import tech.c0ffee.model.Point;
import tech.c0ffee.model.Rectangle;
import org.openjdk.jmh.annotations.*;
import tech.c0ffee.base.AbstractDeserializer;

import java.util.concurrent.TimeUnit;

import static tech.c0ffee.base.AbstractSerializer.NUMBER_OF_ITERATIONS;

/**
 * Overrides deserialization methods using Gson lib
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@Warmup(iterations = NUMBER_OF_ITERATIONS)            //time can be defined here too
@Measurement(iterations = NUMBER_OF_ITERATIONS)       //time can be defined here too
public class GsonDeserializer extends AbstractDeserializer {

    @Benchmark
    public Point[] parseLinear() {
        return new Gson().fromJson(JSON_SMALL, Point[].class);
    }

    @Benchmark
    public Rectangle[] parseComplex() {
        return new Gson().fromJson(JSON_BIG, Rectangle[].class);
    }
}
