package com.redis;

import com.Utils.IpSwitchUtil;
import com.Utils.RedisHyperLogLogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-30 04:39
 **/

@Component
public class HyperLogLogDemo {


    @Autowired
    RedisHyperLogLogUtil<String, String> redisHyperLogLogUtil;



    /**
     * @description:  添加登录ｉp
     * @param:
     * @return:
     * @author: Mr.lgj
     * @date: 8/30/18
    */
    public void hyper(){

        String hyperkey1 = "hyperkey1";
        String hyperkey2 = "hyperkey2";
        String hyperkey3 = "hyperkey3";

        redisHyperLogLogUtil.add(hyperkey1,"a","b","c");
        Long hyperkey1Size  = redisHyperLogLogUtil.size(hyperkey1);
        System.out.println("hyperkey1Size is : " + hyperkey1Size);

        redisHyperLogLogUtil.add(hyperkey2,"a","b","c","e","f","g");
        Long hyperkey2Size  = redisHyperLogLogUtil.size(hyperkey2);
        System.out.println("hyperkey2Size is : " + hyperkey2Size);

        redisHyperLogLogUtil.union(hyperkey3,hyperkey1,hyperkey2);

        redisHyperLogLogUtil.add(hyperkey3,"a","b","c");
        Long hyperkey3Size  = redisHyperLogLogUtil.size(hyperkey3);
        System.out.println("hyperkey3Size is : " + hyperkey3Size);


    }


}
