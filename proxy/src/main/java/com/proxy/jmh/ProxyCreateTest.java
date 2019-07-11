package com.proxy.jmh;

import com.proxy.proxy.CglibProxy;
import com.proxy.proxy.JavassistProxy;
import com.proxy.proxy.JdkInvocationHandler;
import com.proxy.service.ProxyService;
import com.proxy.service.ProxyServiceImpl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 *功能描述
 * @author lgj
 * @Description
 * @date 7/11/19
 *
 * Benchmark                             Mode  Cnt        Score        Error  Units
 * ProxyCreateTest.CglibProxyCreate      avgt   20      192.691 ±      5.962  ns/op
 * ProxyCreateTest.JavassistProxyCreate  avgt   20  2741254.026 ± 334384.484  ns/op
 * ProxyCreateTest.JdkProxyCreate        avgt   20      130.982 ±     14.467  ns/op
 *
 *
 * Benchmark                             Mode  Cnt        Score        Error  Units
 * ProxyCreateTest.CglibProxyCreate      avgt   20      212.150 ±     15.399  ns/op
 * ProxyCreateTest.JavassistProxyCreate  avgt   20  2995729.108 ± 265629.897  ns/op
 * ProxyCreateTest.JdkProxyCreate        avgt   20      124.842 ±      8.404  ns/op
 *
 * Benchmark                             Mode  Cnt        Score        Error  Units
 * ProxyCreateTest.CglibProxyCreate      avgt   20      206.603 ±      6.834  ns/op
 * ProxyCreateTest.JavassistProxyCreate  avgt   20  2979335.282 ± 290935.626  ns/op
 * ProxyCreateTest.JdkProxyCreate        avgt   20      129.260 ±      9.020  ns/op
 *
 *
*/
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ProxyCreateTest {

    public static void main(String args[]) throws Exception{

        Options ops = new OptionsBuilder().include(ProxyCreateTest.class.getSimpleName())
                .forks(1).build();
        new Runner(ops).run();
    }

    @Benchmark
    public void CglibProxyCreate(){
        ProxyService proxyService =  (ProxyService)new CglibProxy().getProxy(ProxyServiceImpl.class);
    }


   @Benchmark
    public void JdkProxyCreate(){
       ProxyService proxyService = (ProxyService) new JdkInvocationHandler(new ProxyServiceImpl()).getProxy();
    }

    @Benchmark
    public void JavassistProxyCreate(){
        ProxyService proxyService = (ProxyService)  new JavassistProxy().getProxy(ProxyServiceImpl.class);
    }




}
