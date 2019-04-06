package com.dubbo.frame.provider;


import com.dubbo.frame.provider.util.ZookeeperUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZookeeperLockApplication {

    public static void main(String[] args)  {

        SpringApplication.run(ZookeeperLockApplication.class,args);
        CuratorFramework client = ZookeeperUtil.getClient();


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
