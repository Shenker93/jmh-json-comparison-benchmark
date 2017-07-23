package tech.c0ffee.gson;

import tech.c0ffee.base.AbstractSerializer;
import org.openjdk.jmh.annotations.*;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import static tech.c0ffee.base.AbstractSerializer.NUMBER_OF_ITERATIONS;

/**
 * Contains benchmarking methods to serialize java objects using Gson lib
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)                            //
@Warmup(iterations = NUMBER_OF_ITERATIONS)            //time can be defined here too
@Measurement(iterations = NUMBER_OF_ITERATIONS)       //time can be defined here too
public class GsonSerializer extends AbstractSerializer {

    @Override
    @Benchmark
    public String objectToJsonString() {
        return new Gson().toJson(testObject);
    }

    @Override
    @Benchmark
    public String pointsToJsonArrayString() {
        return new Gson().toJson(points);
    }

    @Override
    @Benchmark
    public String rectanglesToJsonArrayString() {
        return new Gson().toJson(rectangles);
    }
}
