package com.code.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class JmhDemo {

    public static void main(String args[]) throws Exception{

        Options ops = new OptionsBuilder().include(JmhDemo.class.getSimpleName())
                .forks(1).build();
        new Runner(ops).run();
    }

    @Benchmark
    public void benchmark(){

        try{
            Thread.sleep(88);
        }
        catch(Exception ex){

        }
    }

    @Benchmark
    public void benchmark1(){

        try{
            Thread.sleep(99);
        }
        catch(Exception ex){

        }
    }


}
