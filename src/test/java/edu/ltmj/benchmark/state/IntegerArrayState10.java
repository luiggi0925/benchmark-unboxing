package edu.ltmj.benchmark.state;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class IntegerArrayState10 {

    Integer[] data;
    
    @Setup(Level.Trial)
    public void init() {
        data = new Integer[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = i+1;
        }
    }

    public Integer[] getData() {
        return data;
    }
}
