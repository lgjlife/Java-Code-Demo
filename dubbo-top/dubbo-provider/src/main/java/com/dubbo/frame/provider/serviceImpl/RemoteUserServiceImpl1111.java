package com.dubbo.frame.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.frame.common.service.RemoteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@Service(version = "1.0.0",timeout = 10000,weight = 50,loadbalance = "leastactive" ,protocol = "dubbo")
public class RemoteUserServiceImpl1111 implements RemoteUserService {

    AtomicInteger count = new AtomicInteger(0);

    @Override
    public String sayHello(String name) {

        try{
            Thread.sleep(50);
        }
        catch (Exception ex){

        }
        int c = count.incrementAndGet();
        log.info("访问sayHello " + name + "  调用次数 = " + c);
        if(c > 2){
            log.info("NullPointerException");
            throw  new NullPointerException();
        }

        return "Hello " + name + " ,I am provider - 0";
    }

    @Override
    public String sayHello1(String name, int data) {
        return null;
    }

    @Override
    public String sayHello2(String name, int data, int data1) {
        return null;
    }
}

