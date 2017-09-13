package edu.ltmj.benchmark;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/**
 * Example of how to create a micro benchmark and run it
 * using an IDE. Using Eclipse for this case.
 * @author luiggimendoza
 *
 */
public class BenchmarkExecutor {
    /**
     * Test to execute the benchmarks in this class.
     * @throws Exception because Runner#run may throw Exception
     */
    @Test
    public void launchBenchmark() throws Exception {
        Options opt = new OptionsBuilder()
                // Specify which benchmarks to run.
                // You can be more specific if you'd like to run only one
                // benchmark per test.
                .include(ConverterBenchmarks.class.getName())
                // Set the following options as needed
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS).warmupTime(TimeValue.seconds(10))
                .warmupIterations(5)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .jvmArgsAppend("-server")
                .threads(2)
                .forks(2)
                .resultFormat(ResultFormatType.TEXT)
                .shouldFailOnError(true).shouldDoGC(false)
                .build();

        new Runner(opt).run();
    }
}