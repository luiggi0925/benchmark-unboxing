package edu.ltmj.benchmark;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import edu.ltmj.benchmark.state.IntegerArrayState10;

public class ConverterBenchmarks {

    @Benchmark
    public void benchmarkNoUnboxing10(IntegerArrayState10 state, Blackhole hole) {
        Integer[] data = state.getData();
        Set<Integer> dataSet = new TreeSet<>(Arrays.asList(data));
        for (Integer statue : dataSet) {
            hole.consume(statue);
        }
    }

    @Benchmark
    public void benchmarkNoUnboxing10_000(IntegerArrayState10 state, Blackhole hole) {
        Integer[] data = state.getData();
        Set<Integer> dataSet = new TreeSet<>(Arrays.asList(data));
        for (Integer statue : dataSet) {
            hole.consume(statue);
        }
    }

    @Benchmark
    public void benchmarkUnboxing10(IntegerArrayState10 state, Blackhole hole) {
        Integer[] data = state.getData();
        Set<Integer> dataSet = new TreeSet<>(Arrays.asList(data));
        for (int statue : dataSet) {
            hole.consume(statue);
        }
    }

    @Benchmark
    public void benchmarkUnboxing10_000(IntegerArrayState10 state, Blackhole hole) {
        Integer[] data = state.getData();
        Set<Integer> dataSet = new TreeSet<>(Arrays.asList(data));
        for (int statue : dataSet) {
            hole.consume(statue);
        }
    }
}
