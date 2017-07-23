package tech.c0ffee.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.openjdk.jmh.annotations.*;
import tech.c0ffee.base.AbstractSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

import static tech.c0ffee.base.AbstractSerializer.NUMBER_OF_ITERATIONS;

/**
 * Contains benchmarking methods to serialize java objects using Jackson lib
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)                            //
@Warmup(iterations = NUMBER_OF_ITERATIONS)            //time can be defined here too
@Measurement(iterations = NUMBER_OF_ITERATIONS)       //time can be defined here too
public class JacksonSerializer extends AbstractSerializer {

    private String objectToJsonString(Object o) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    @Benchmark
    public String objectToJsonString() {
        return objectToJsonString(testObject);
    }

    @Override
    @Benchmark
    public String pointsToJsonArrayString() {
        return objectToJsonString(points);
    }

    @Override
    @Benchmark
    public String rectanglesToJsonArrayString() {
        return objectToJsonString(rectangles);
    }
}