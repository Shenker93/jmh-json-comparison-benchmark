package tech.c0ffee.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import tech.c0ffee.model.Point;
import tech.c0ffee.model.Rectangle;
import org.openjdk.jmh.annotations.*;
import tech.c0ffee.base.AbstractDeserializer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static tech.c0ffee.base.AbstractSerializer.NUMBER_OF_ITERATIONS;

/**
 * Overrides deserialization methods using Jackson lib
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)                            //
@Warmup(iterations = NUMBER_OF_ITERATIONS)            //time can be defined here too
@Measurement(iterations = NUMBER_OF_ITERATIONS)       //time can be defined here too
public class JacksonDeserializer extends AbstractDeserializer {

    @Benchmark
    @Override
    public Point[] parseLinear() {
        try {
            return new ObjectMapper()
                    .readValue(JSON_SMALL, Point[].class);

        } catch (IOException ex) {
            ex.printStackTrace();
            return new Point[0];
        }
    }

    @Benchmark
    @Override
    public Rectangle[] parseComplex() {
        try {
            return new ObjectMapper()
                    .readValue(JSON_BIG, Rectangle[].class);

        } catch (IOException ex) {
            ex.printStackTrace();
            return new Rectangle[0];
        }
    }
}
