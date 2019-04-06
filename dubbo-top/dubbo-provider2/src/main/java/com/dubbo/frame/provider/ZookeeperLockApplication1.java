package com.dubbo.frame.provider;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZookeeperLockApplication1 {

    public static void main(String[] args)  {
        SpringApplication.run(ZookeeperLockApplication1.class, args);


        RetryPolicy retryPolicy
                = new ExponentialBackoffRetry(1000,3);

        CuratorFramework client;
        client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);

        client.start();


//创建分布式锁, 锁空间的根节点路径为/curator/lock

        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");

        try {
            mutex.acquire();
             //获得了锁, 进行业务流程
            System.out.println("Enter mutex");
            //完成业务流程, 释放锁
            mutex.release();
            //关闭客户端
            client.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
