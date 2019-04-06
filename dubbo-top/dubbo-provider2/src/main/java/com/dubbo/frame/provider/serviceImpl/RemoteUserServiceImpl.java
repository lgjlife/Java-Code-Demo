package com.dubbo.frame.provider.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.frame.common.service.RemoteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@Service(version = "1.0.0",timeout = 10000,weight = 33,loadbalance = "leastactive")
public class RemoteUserServiceImpl implements RemoteUserService {

    AtomicInteger count = new AtomicInteger(0);

    @Override
    public String sayHello(String name) {

        int c = count.incrementAndGet();
        log.info("访问sayHello " + name + "  调用次数 = " + c);
        return "Hello " + name + " ,I am provider - 2";
    }
}

