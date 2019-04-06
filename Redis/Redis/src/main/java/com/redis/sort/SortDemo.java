package com.redis.sort;

import com.Utils.RedisListUtil;
import com.Utils.RedisStringsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.query.SortQuery;
import org.springframework.data.redis.core.query.SortQueryBuilder;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: demo
 * @description: Sort 使用　，有问题，不能排序
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-29 02:18
 **/

@Component
public class SortDemo {

    //ToDo sort 失败
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisStringsUtil<String,Integer> redisStringsUtil;

    @Autowired
    RedisListUtil<String,String> redisListUtil;
    public void sortDemo(){
        String key = "sort-key-list";
        Random random = new Random();


        for(int i = 0 ; i < 100;i++){
            int num = random.nextInt(1000);
            redisListUtil.leftPush(key,num+"") ; //set("sort-key-"+i,i);
        }

        System.out.println("lpop value = " +
                redisListUtil.leftPop(key));

        SortQuery<String> sortQuery = SortQueryBuilder.sort(key)
                                                     // .noSort()
                                                      .order(SortParameters.Order.ASC)
                                                      .limit(0,10)
                                                      .alphabetical(true).build();
        List<String> numList = redisTemplate.sort(sortQuery);

        System.out.println("numList lenth is :" + numList.size());
        for(String num : numList){
            System.out.print("  " + num );
        }

        System.out.println();
        //redisTemplate.boundListOps(key)
    }

}
