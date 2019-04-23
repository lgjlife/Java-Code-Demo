package com.dubbo.frame.provider1.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.frame.common.service.RemoteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@Service(version = "1.0.0",timeout = 10000,weight = 50,loadbalance = "random")
public class RemoteUserServiceImpl1111 implements RemoteUserService {

    AtomicInteger count = new AtomicInteger(0);

    @Override
    public String sayHello(String name) {

        int c = count.incrementAndGet();
        String  str = "RemoteUserServiceImpl1111:" + c + "-" + "请求参数:" + name;
        log.info(str);
        return str;
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

