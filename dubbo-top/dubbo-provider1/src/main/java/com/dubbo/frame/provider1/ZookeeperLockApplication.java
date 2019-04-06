package com.dubbo.frame.provider1;


import com.dubbo.frame.provider1.util.ZookeeperUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ZookeeperLockApplication {

    private void createRootPath(){


    }

    public static void main(String[] args)  {

        SpringApplication.run(ZookeeperLockApplication.class,args);
        CuratorFramework client = ZookeeperUtil.getClient();


        try{
            if(client.checkExists().forPath("/app")==null){
                log.debug("目录[]不存在，创建目录....","/app");
                client.create().creatingParentsIfNeeded().forPath("/app");
            }
            else {
                log.debug("目录[]已经存在","/app");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        try{
            byte[] data = null;
            data = client.getData().usingWatcher(new CuratorWatcher() {
                @Override
                public void process(WatchedEvent watchedEvent) throws Exception {
                    System.out.println("watchedEvent = " + watchedEvent );

                }
            }).forPath("/app");
            System.out.println("data = " + new String(data));
           // ZookeeperUtil.setListenterOne(client);
          //  ZookeeperUtil.setListenterTwo(client);
           // ZookeeperUtil.setListenterThreeOne(client);

           // ZookeeperUtil.setListenterThreeTwo(client);

            ZookeeperUtil.setListenterThreeThree(client);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }

}
