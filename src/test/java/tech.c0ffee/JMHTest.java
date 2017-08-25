package tech.c0ffee;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Actually starts JMH benchmark
 */
public class JMHTest {

    @Test
    public void startBenchmark() throws Exception{

        // Specify benchmark classes to run
        final Options opt = new OptionsBuilder()
                .include("tech.c0ffee.gson.GsonDeserializer.*")
                .include("tech.c0ffee.gson.GsonSerializer.*")
                .include("tech.c0ffee.jackson.JacksonDeserializer.*")
                .include("tech.c0ffee.jackson.JacksonSerializer.*")
                .build();
        new Runner(opt).run();
    }
}
