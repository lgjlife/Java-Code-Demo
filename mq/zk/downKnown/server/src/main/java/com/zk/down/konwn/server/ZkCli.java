package com.zk.down.konwn.server;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
        log.debug("zookeeper client start....");
        //  setListener(client);
    }

    public void create(String server){

        try{
            String result = client.create().creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    .forPath(rootPath + "/aaa/" +server,new Date().toString().getBytes());
            log.info("创建结果 = " + result);
           /* client.setData().forPath(rootPath,"aaaa".getBytes());
            for(int i = 0; i< 10; i++){
              Stat res =  client.setData().forPath(rootPath,(i+aserver).getBytes());
               // log.info("创建结果 = " + res.toString());
            }*/



        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }


    }

    public void create2(String server){
        String rootPath1 =  "/rootPath1";
        String path = rootPath1 + "/" +server;

        try{

            if(client.checkExists().forPath(path)== null){
                log.debug("path[{}]不存在，创建节点",path);
                String result = client.create().creatingParentsIfNeeded()
                        .forPath(path);
                log.info("创建结果 = " + result);
            }

            Stat res =  client.setData().forPath(path,("aaaa-" + new Random().nextInt(1000)).getBytes());
            log.info("创建结果 = " + res.toString());

            List<String> paths = client.getChildren().forPath(rootPath1);
            paths.forEach((v)->{
                        log.debug("path = " + v);
                    }
                    );

        }
        catch(Exception ex){
            log.error(ex.getMessage());
        }


    }



    @PostConstruct
    public void init(){
        log.info("ZkCli  init");
        this.connect();
        this.create("aserver-1");
        this.create2("aserver-5/sub1/"+ new Random().nextInt(100));
    }

}
