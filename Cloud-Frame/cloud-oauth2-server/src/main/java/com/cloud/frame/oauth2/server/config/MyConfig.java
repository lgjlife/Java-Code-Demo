package com.cloud.frame.oauth2.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-12-18 14:59
 **/

//@Configuration
public class MyConfig {

    @Value("${aserver.port}")
    private String port;

    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;
    //最大空闲处
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    //最大等待时间
    @Value("${spring.redis.jedis.pool.max-wait}")
    private String maxWait;
    //连接池中的最小空闲连接
    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;


    @Bean
    public  User user(){
        System.out.println("port = " + port );
        System.out.println(toString());
        return  new User();
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "port='" + port + '\'' +
                ", maxActive=" + maxActive +
                ", maxIdle=" + maxIdle +
                ", maxWait='" + maxWait + '\'' +
                ", minIdle=" + minIdle +
                '}';
    }
}
class User{

}