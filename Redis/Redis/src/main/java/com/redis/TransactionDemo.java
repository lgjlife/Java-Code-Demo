package com.redis;

import com.Utils.RedisStringsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * @program: demo
 * @description: 事务处理
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-08-28 23:31
 **/
@Component
public class TransactionDemo {

    private static  final Logger  log = LoggerFactory.getLogger("TransactionDemo");

    @Autowired
    RedisStringsUtil<String,Object> redisStringsUtil;

    @Autowired
   // @Qualifier()
    RedisTemplate<String,Object>  redisTemplate;

    /** 
     * @description:   multi() :启用事务 　　exec()　：　提交
     *                 只有调用exec之后才会提交
     *
     * @param: 　
     * @return:
     * @author: Mr.lgj 
     * @date: 8/29/18 
    */ 
    public void transaction(){
        //Pipeline
        String name = "name";
        String value = "123456";

        redisStringsUtil.set(name,"init value");
        try {
            redisTemplate.multi();
            if(true == redisStringsUtil.set(name,value)){

                //抛出异常，事务未提交　，上述设置无效
                throw new IllegalArgumentException();
            }

            redisTemplate.exec();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        log.info("The value of the key[name] is :" + redisStringsUtil.get(name));
        log.info("transaction 执行完毕．．．．．．");

    }


    /** 
     * @description:    有问题，redisTemplate.watch　报错　UnsupportedOperationException　
     * @param:  
     * @return:  
     * @author: Mr.lgj 
     * @date: 8/29/18 
    */

    @Transactional
    public void transaction1(){
        //Todo  transaction1 报错　　UnsupportedOperationException
        //Pipeline
        log.info("执行　transaction1　.........");
        String name = "name";
        String value = "123456";

     //   redisStringsUtil.set(name,"init value");
        try {

            redisTemplate.setEnableTransactionSupport(true);
            RedisConnectionFactory factory = redisTemplate.getConnectionFactory();
            JedisConnection con = (JedisConnection)factory.getConnection();
            con.multi();
            System.out.println("isQueueing = " + con.isQueueing());
            redisTemplate.multi();
            System.out.println("isQueueing = " + con.isQueueing());
            redisTemplate.watch("sadsadas");
            redisStringsUtil.set(name,value);
            log.info("The value of the key[name] is :" + redisStringsUtil.get(name));

            redisTemplate.exec();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        log.info("The value of the key[name] is :" + redisStringsUtil.get(name));
        log.info("transaction 执行完毕．．．．．．");

    }


}
