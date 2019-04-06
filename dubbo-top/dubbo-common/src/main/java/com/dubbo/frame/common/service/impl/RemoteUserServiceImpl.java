package com.dubbo.frame.common.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.frame.common.service.RemoteUserService;
import org.springframework.stereotype.Component;


@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = RemoteUserService.class)
public class RemoteUserServiceImpl implements RemoteUserService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
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

