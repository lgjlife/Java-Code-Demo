package com.proxy.jmh;

import com.proxy.proxy.CglibProxy;
import com.proxy.proxy.JavassistProxy;
import com.proxy.proxy.JdkInvocationHandler;
import com.proxy.service.ProxyService;
import com.proxy.service.ProxyServiceImpl;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 *功能描述
 * @author lgj
 * @Description
 * @date 7/11/19
Benchmark                       Mode  Cnt   Score   Error  Units
ProxyRunTest.CglibProxyRun      avgt   20   9.918 ± 1.268  ns/op
ProxyRunTest.JavassistProxyRun  avgt   20  34.226 ± 2.655  ns/op
ProxyRunTest.JdkProxyRun        avgt   20   5.225 ± 0.449  ns/op

Benchmark                       Mode  Cnt   Score   Error  Units
ProxyRunTest.CglibProxyRun      avgt   20   6.975 ± 0.629  ns/op
ProxyRunTest.JavassistProxyRun  avgt   20  31.707 ± 0.885  ns/op
ProxyRunTest.JdkProxyRun        avgt   20   5.442 ± 0.514  ns/op

Benchmark                       Mode  Cnt   Score   Error  Units
ProxyRunTest.CglibProxyRun      avgt   20   8.079 ± 1.381  ns/op
ProxyRunTest.JavassistProxyRun  avgt   20  33.916 ± 2.904  ns/op
ProxyRunTest.JdkProxyRun        avgt   20   5.947 ± 0.498  ns/op

 */
//https://www.cnblogs.com/fightfordream/p/9353002.html#state
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ProxyRunTest {


    private  ProxyService proxyServiceCglib =  (ProxyService)new CglibProxy().getProxy(ProxyServiceImpl.class);
    private  ProxyService proxyServiceJdk = (ProxyService) new JdkInvocationHandler(new ProxyServiceImpl()).getProxy();
    private  ProxyService proxyServiceJavassist = (ProxyService)  new JavassistProxy().getProxy(ProxyServiceImpl.class);
    public static void main(String args[]) throws Exception{

        Options ops = new OptionsBuilder().include(ProxyRunTest.class.getSimpleName())
                .forks(1).build();
        new Runner(ops).run();
    }

    @Benchmark
    public void CglibProxyRun(){
        proxyServiceCglib.run();


    }


   @Benchmark
    public void JdkProxyRun(){
       proxyServiceJdk.run();
    }

    @Benchmark
    public void JavassistProxyRun(){
        proxyServiceJavassist.run();
    }




}
