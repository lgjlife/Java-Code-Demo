package com.zk.down.konwn.server;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ZkCli {


    private  CuratorFramework client;

    private  String rootPath = "/servers";

    public void connect() {
        //拒绝策略
        RetryPolicy retryPolicy
                = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",
                retryPolicy);
        client.start();

        ZkListener zkListener =  new ZkListener();
        zkListener.setListener(client,rootPath);
        log.debug("zookeeper client start....");
        //  setListener(client);
    }

    public void create(String server){

        try{
            String result = client.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    .forPath(rootPath + "/ " + server);
            log.info("创建结果 = " + result);

        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }


    }

    @PostConstruct
    public void init(){
        log.info("ZkCli  init");
        this.connect();
      //  this.create("server-1");

    }

}
