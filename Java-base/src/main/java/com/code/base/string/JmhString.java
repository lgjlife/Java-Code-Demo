package com.code.base.string;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JmhString {

    public static void main(String args[]) throws Exception{

        Options ops = new OptionsBuilder().include(JmhString.class.getSimpleName())
                .forks(1).build();
        new Runner(ops).run();
    }

   // @Benchmark
    public void benchmark1(){

        String str = "aaaaa" + "bbbb" + "ccccc"+"aaaaa" + "bbbb" + "ccccc"+"aaaaa" + "bbbb" + "ccccc"+"aaaaa" + "bbbb" + "ccccc";
    }

  //  @Benchmark
    public void benchmark2(){
        String str1 = "aaaaa";
        String str2 = "bbbb";
        String str3 = "ccccc";
        String str4 = "aaaaa";
        String str5 ="bbbb";
        String str6 ="ccccc";

        String str = str1+str2+str3+str4+str5+str6+str1+str2+str3+str4+str5+str6;

    }

    //@Benchmark
    public void benchmark3(){
        String str1 = "aaaaa";
        String str2 = "bbbb";
        String str3 = "ccccc";
        String str4 = "aaaaa";
        String str5 ="bbbb";
        String str6 ="ccccc";

        String str = new StringBuilder().append(str1).append(str2).append(str3).append(str4).append(str5).append(str6).
                append(str1).append(str2).append(str3).append(str4).append(str5).append(str6).toString();

    }

  //  @Benchmark
    public void benchmark4(){
        String str = new StringBuilder().append("aaaaa").append("bbbb")
                .append("ccccc").append("aaaaa").append("bbbb").append("ccccc").append("aaaaa").append("bbbb")
                .append("ccccc").append("aaaaa").append("bbbb").append("ccccc").toString();

    }


    //@Benchmark
    public void benchmark5(){

        String str = "";
        int i =0;
        while(i++ < 100){
            str+=i;
        }



    }

   // @Benchmark
    public void benchmark6(){

        StringBuilder builder = new StringBuilder();

        int i =0;
        while(i++ < 100){
            builder.append(i);
        }

        String str = builder.toString();

    }

   // @Benchmark
    public void benchmark7(){

        StringBuffer builder = new StringBuffer();

        int i =0;
        while(i++ < 100){
            builder.append(i);
        }

        String str = builder.toString();

    }
    @Benchmark
    public void benchmark8(){


        int i =0;
        while(i < 1000000000){
            i++;
        }



    }
    @Benchmark
    public void benchmark9(){


        int i =0;
        while(i < 100000000){

            try{
                i++;
            }
            catch(Exception ex){
            }
        }



    }




}
